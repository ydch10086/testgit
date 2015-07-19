package com.yd.common.function.auth.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yd.common.auth.CIPAuthManager;
import com.yd.common.auth.CIPResource;
import com.yd.common.cache.CIPCacheManager;
import com.yd.common.cache.CIPCacheService;
import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.function.admin.dao.CIP_admin_resourceDao;
import com.yd.common.function.admin.dao.CIP_admin_resource_2_resourceDao;
import com.yd.common.function.admin.dao.CIP_admin_rolesDao;
import com.yd.common.function.admin.data.po.CIP_admin_rolesPO;
import com.yd.common.function.auth.dao.CIPRole2ResourceDao;
import com.yd.common.function.auth.data.CIPRole2ResourceData;
import com.yd.common.function.auth.service.CIPResourceService;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntime;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.runtime.CIPRuntimeConstants;
import com.yd.common.session.CIPUser;

@Service
public class CIPResourceServiceImpl implements CIPResourceService {

	@Autowired
	private CIP_admin_rolesDao roleDao = null;
	@Autowired
	private CIPRole2ResourceDao role2ResDao = null;
	@Autowired
	private CIP_admin_resource_2_resourceDao resource2resourceDao = null;
	@Autowired
	private CIP_admin_resourceDao resourceDao = null;

	@Override
	public List<CIPResource> getResources(CIPUser user) {
		if( user == null ){
			throw new CIPRuntimeException(CIPErrorCode.ERROR_ILLEGAL_ACCESS);
		}
		List<String> userRoles = user.getUserRoles();
		CIPResource[] tempResources;
		CIPResource resource;
		CIPResource resource0;
		List<CIPResource> menus = new ArrayList<CIPResource>();

		if (userRoles == null || userRoles.size() == 0) {
			return menus;
		}

		//添加从缓存中获取菜单
		if (CIPRuntimeConfigure.cip_user_xremote) {
			menus = CIPRuntime.authManager.getAuthResource(user.getUserId());
			return menus;
		}

		Map<String, CIPResource> mResources = new LinkedHashMap<String, CIPResource>();
		for (String userRole : userRoles) {
			CIPCacheService cache = CIPCacheManager.getCacheService();
			tempResources = cache.get(CIPRuntimeConfigure.cip_system_id+"_"+CIPRuntimeConstants.CIP_MENU_ID
					+ userRole, CIPResource[].class);
			if (tempResources == null) {
				// 本地角色与资源关联信息
				CIP_admin_rolesPO role = roleDao.getSingle(userRole);
				String resourceId = role.getRoot_resource_id();
				List<CIPRole2ResourceData>  resourceDBs = role2ResDao.getResources(resourceId);
				
				tempResources = convertUIResource(resourceId,resourceDBs);
			
				cache.set(CIPRuntimeConfigure.cip_system_id+"_"+ CIPRuntimeConstants.CIP_MENU_ID + userRole,
						tempResources, true);

			}
			for (CIPResource r : tempResources) {
				//多角色背景下，只做第一级菜单合并，若是重复菜单，则忽略
				resource = mResources.get(r.id);
				if (resource == null){
					mResources.put(r.id, r);
					for (CIPResource temp : r.menus) {
						mResources.put(temp.id, temp);
					}
				}
			}
		}
		Set<String> keys = mResources.keySet();
		for (String key : keys) {
			resource = mResources.get(key);
			if (resource.level == 0) {
				menus.add(resource);
				resource.menus = new ArrayList<CIPResource>();
			}
		}

		for (String key : keys) {
			resource = mResources.get(key);
			if (resource.level != 0) {
				resource0 = mResources.get(resource.group);
				resource0.menus.add(resource);
			}
		}
		

		return menus;
	}

	
	/***********************************************************************************
	 * 
	 * 使用该函数前提条件：
	 * 1：树根层级必须是从-1开始
	 * 2: 数所有节点数据必须包含三类信息：父节点id，当前树层级，当前是否是叶节点
	 * 3: 按照数层级从小到大排序好数据
	 * 4: 所有非根节点数据必须有上级节点，否则结构异常
	 * 
	 ***********************************************************************************/
	private CIPResource[] convertUIResource(
			String resourceId, List<CIPRole2ResourceData> resourceDBs) {
		if( resourceDBs == null )
			return null;
		int length = resourceDBs.size();
		Map<Integer, Map<String,CIPResource>> resources = new LinkedHashMap<Integer, Map<String,CIPResource>>();
		Map<String,CIPResource> parentR = null;
		Map<String,CIPResource> currentR = null;
		CIPRole2ResourceData r;
		CIPResource uiR = null;
		CIPResource tempR;
		String parentNode = null;
		int level=-1;
		int baseLevel = -1;
		int leafFlag;
			
		for(int i = 0; i < length ; i++){
			r = resourceDBs.get(i);
			if(r.getResource_type().equals("B")||r.getResource_type().equals("P"))
				continue;
			
			level = r.getLevel();
			leafFlag = r.getLeaf_flag();
			if(level >= baseLevel){
				uiR = new CIPResource();
				uiR.group = r.getRes_node_sup();
				uiR.id = r.getResource_id();
				uiR.url = r.getSys_uri();
				uiR.level = level;
				uiR.name = r.getResource_name();
				uiR.type = r.getResource_type();
				if(leafFlag==0)
					uiR.menus = new ArrayList<CIPResource>();
				
				resources.put(level, new HashMap<String,CIPResource>());
				resources.get(level).put(uiR.id,uiR);
				baseLevel = level + 1;
				
				if( level > -1 ){
					parentR = resources.get(level-1);
					if( parentR == null )
						throw new CIPRuntimeException(CIPErrorCode.ERROR_DATA_IS_MALFORM);
					parentNode = r.getRes_node_sup();
					tempR = parentR.get(parentNode);
					if(tempR==null)
						throw new CIPRuntimeException(CIPErrorCode.ERROR_DATA_IS_MALFORM);
					
					tempR.menus.add(uiR);
				}
			}
			else if( level < baseLevel){
				if( level == -1 ){
					currentR = resources.get(level);
					uiR = new CIPResource();
					uiR.group = r.getRes_node_sup();
					uiR.id = r.getResource_id();
					uiR.url = r.getSys_uri();
					uiR.level = level;
					uiR.name = r.getResource_name();
					uiR.type = r.getResource_type();
					uiR.menus = new ArrayList<CIPResource>();
					currentR.put(uiR.id,uiR);
				}
				else {
					parentR = resources.get(level-1);
					if( parentR == null )
						throw new CIPRuntimeException(CIPErrorCode.ERROR_DATA_IS_MALFORM);
					
					currentR = resources.get(level);
					parentNode = r.getRes_node_sup();
					tempR = parentR.get(parentNode);
					if(tempR==null)
						throw new CIPRuntimeException(CIPErrorCode.ERROR_DATA_IS_MALFORM);
					
					uiR = new CIPResource();
					uiR.group = parentNode;
					uiR.id = r.getResource_id();
					uiR.url = r.getSys_uri();
					uiR.level = level;
					uiR.name = r.getResource_name();
					uiR.type = r.getResource_type();
					if(leafFlag==0)
						uiR.menus = new ArrayList<CIPResource>();
					
					currentR.put(uiR.id, uiR);
					
					tempR.menus.add(uiR);
				}
			}
		}
					
		
		currentR = resources.get(0); //返回根菜单信息
		if(currentR!=null)
			return currentR.values().toArray(new CIPResource[currentR.size()]);
		return null;
	}


	@Override
	public List<CIPResource> getResources(CIPUser user, String reqResourceId) {
		if( user == null ){
			throw new CIPRuntimeException(CIPErrorCode.ERROR_ILLEGAL_ACCESS);
		}
		List<String> userRoles = user.getUserRoles();
		CIPResource[] tempResources = null;
		CIPResource resource;

		Map<String, CIPResource> mResources = new LinkedHashMap<String, CIPResource>();
		for (String userRole : userRoles) {
			
			if (CIPRuntimeConfigure.cip_user_xremote) {
				tempResources = CIPRuntime.authManager.getAuthResource(user.getUserId(), reqResourceId);
			} else {
				// 本地角色与资源关联信息
				CIP_admin_rolesPO role = roleDao.getSingle(userRole);
				String resourceId = role.getRoot_resource_id();
				List<CIPRole2ResourceData>  resourceDBs = role2ResDao.getActionResources(resourceId,reqResourceId); 
				
				tempResources = new CIPResource[resourceDBs.size()];
				int length = resourceDBs.size();
				CIPResource uiR;
				CIPRole2ResourceData r;
				for(int i=0;i<length;i++){
					r = resourceDBs.get(i);
					if(!r.getResource_type().equals("B")){
						continue;
					}
					uiR = new CIPResource();
					uiR.group = reqResourceId;
					uiR.id = r.getResource_id();
					uiR.url = r.getSys_uri();
					uiR.level = 0;
					uiR.name = r.getResource_name();
					uiR.type = r.getResource_type();
					
					tempResources[i] = uiR;
				}
			}
		
			for (CIPResource r : tempResources) {
				//多角色背景下，只做第一级菜单合并，若是重复菜单则忽略
				resource = mResources.get(r.id);
				if (resource == null){
					mResources.put(r.id, r);
				}
			}
		}
		
		if(!mResources.isEmpty()){
			List<CIPResource> buttons = new ArrayList<CIPResource>(mResources.size());
			Iterator<CIPResource> it = mResources.values().iterator();
			while(it.hasNext()){
				buttons.add(it.next());
			}
			return buttons;
		}
		
		return null;
	}


	@Override
	public void initResource(String userRole) {
		CIPRuntime.authManager.reloadResources(userRole);
	}


	@Override
	public void reloadResources() {
		CIPRuntime.authManager.reloadResources();
	}

}
