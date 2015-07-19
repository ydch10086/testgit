package com.yd.common.auth;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.alibaba.fastjson.JSON;
import com.yd.common.auth.behavior.CIPAuthKey;
import com.yd.common.auth.behavior.CIPAuthLock;
import com.yd.common.auth.behavior.CIPAuthObject;
import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.function.admin.dao.CIP_admin_auth_act2objDao;
import com.yd.common.function.admin.dao.CIP_admin_auth_attrDao;
import com.yd.common.function.admin.dao.CIP_admin_auth_objDao;
import com.yd.common.function.admin.dao.CIP_admin_auth_roleDao;
import com.yd.common.function.admin.dao.CIP_admin_auth_userDao;
import com.yd.common.function.admin.dao.CIP_admin_resourceDao;
import com.yd.common.function.admin.dao.CIP_admin_resource_2_resourceDao;
import com.yd.common.function.admin.dao.CIP_admin_rolesDao;
import com.yd.common.function.admin.data.po.CIP_admin_auth_act2objPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_attrPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_objPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_rolePO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_userPO;
import com.yd.common.function.admin.data.po.CIP_admin_rolesPO;
import com.yd.common.function.auth.dao.CIPRole2ResourceDao;
import com.yd.common.function.auth.data.CIPRole2ResourceData;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntime;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.runtime.CIPRuntimeConstants;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.session.CIPHttpSession;
import com.yd.common.session.CIPUser;
import com.yd.common.utils.HttpUtils;
import com.yd.common.utils.JSONUtils;

@Service
public class CIPAuthManager {
	
	@Autowired
	private CIP_admin_rolesDao roleDao = null;
	@Autowired
	private CIPRole2ResourceDao role2ResDao = null;
	@Autowired
	private CIP_admin_resource_2_resourceDao resource2resourceDao = null;
	@Autowired
	private CIP_admin_resourceDao resourceDao = null;
	@Autowired
	private CIP_admin_auth_userDao authUserDao = null;
	@Autowired
	private CIP_admin_auth_roleDao authRoleDao = null;
	@Autowired
	private CIP_admin_auth_objDao authObjDao = null;
	@Autowired
	private CIP_admin_auth_attrDao authAttrDao = null;
	@Autowired
	private CIP_admin_auth_act2objDao auth2ObjDao = null;
	
	private Map<String,List<String>> userRoles = new HashMap<String,List<String>>();
	private Map<String, CIP_admin_rolesPO> mRoles = new HashMap<String, CIP_admin_rolesPO>();
	private Map<String,Map<String,String>> userAuths = new HashMap<String,Map<String,String>>();
	private Map<String,String> mAuthObjects = new HashMap<String,String>();
	private Map<String,List<String>> mAuthAttributes = new HashMap<String,List<String>>();
	private Map<String,Map<String,String>> roleAuths = null;
	private Map<String,CIPAuthObject> authObjects = new HashMap<String, CIPAuthObject>();
	private Map<String,String> authUserColumns = null;
	
	private Map<String, Map<String,String>> mAuthResources = new HashMap<String,Map<String,String>>();
	
	private Map<String, CIPUserProfileData> mUsers = new HashMap<String,CIPUserProfileData>();
	
	//0.初始化授权管理
	public void init(){
		initRoles();
		initUserColumns();
		initRoleAuth();
		initAuthObject();
		reloadResources();
	}
	
	//0.用户验证-remote validation
	public boolean validateUser(String userId, String pwd){
		//封装参数
		Map<String, String> params = new HashMap<String, String>();
		params.put("authId", String.valueOf(CIPRuntimeConfigure.cip_auth_Id));
		params.put("userId", userId);
		params.put("password", pwd);
		
		CIPUserProfileData user = new CIPUserProfileData();
		try {
			//POST请求获取数据
			String response = HttpUtils.post(CIPRuntimeConfigure.cip_login_url, params);
			Map<String, Object> responseMap  = JSONUtils.convertJson2Map(response);
			int retcode = (int) responseMap.get("retcode");
		
			if(retcode!=0) {//登录失败
				return false;
			}else{
				boolean result = (boolean) responseMap.get("result");
				if(!result){
					return false; 
				}
			}
			
			Map<String, Object> userMap = (Map<String, Object>) responseMap.get("userData");
			//解析用户基本信息
			user.user_id = userId;
			user.user_name = (String)userMap.get("userName");
			user.org_id = (String)userMap.get("orgCode");
			//user.org_name = (String)userMap.get("orgName");

			//登录成功后将用户信息放入缓存中
			mUsers.put(userId, user);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void setUserProfile(CIPUserProfileData userData){
		mUsers.put(userData.user_id, userData);
	}
	
	
	//1.资源授权-romote
	public List<CIPResource> getAuthResource(String userId){
		//封装参数
		Map<String, String> params = new HashMap<String, String>();
		params.put("authId", String.valueOf(CIPRuntimeConfigure.cip_auth_Id));
		params.put("userId", userId);
		List<CIPResource> menus = null;
		try {
			String response = HttpUtils.post(CIPRuntimeConfigure.cip_menu_url, params);
			Map<String, Object> responseMap  = JSONUtils.convertJson2Object(response, Map.class);
			int retcode = (int) responseMap.get("retcode");

			if(retcode!=0) {//接口调用失败
				String retmsg = (String)responseMap.get("retmsg");
				throw new Exception(retmsg);
			}
			menus= JSON.parseArray(JSON.toJSONString(responseMap.get("menus")), CIPResource.class);
		} catch (Exception e) {
			throw new CIPRuntimeException(CIPErrorCode.ERROR_TECHNICAL_ERROR);
		}
		return menus;
	}
	
	public CIPResource[] getAuthResource(String userId, String resourceId){
		
		return null;
	}
	
	//3. 初始化用户权限字段信息
	public void initUserAuth(CIPUser user){
		userRoles.put(user.getUserId(), user.getUserRoles());
		CIPUserProfileData userProfile = mUsers.get(user.getUserId());
		Map<String,String> userAuth = userAuths.get(user.getUserId());
		if(userAuth==null){
			//本地用户权限字段配置表 == > 获取当前用户的相关字段信息
			if(authUserColumns != null){
				Set<String> columns = authUserColumns.keySet();
				userAuth = new HashMap<String,String>(columns.size());
				Object columnValue;
				for(String column:columns){
					columnValue = getFieldValue(userProfile,column);
					if(columnValue!=null){
						userAuth.put(column, columnValue.toString());
					}
				}
				userAuths.put(user.getUserId(), userAuth);
			}
			else {
				userAuth = new HashMap<String,String>();
				userAuths.put(user.getUserId(), userAuth);
			}
			
			//本地角色权限值配置表 ==》 角色权限配置信息 合并
			List<String> roles = user.getUserRoles();
			Map<String, String> roleAuth;
			for( String role:roles){
				roleAuth = roleAuths.get(role);
				if( roleAuth != null )
					userAuth.putAll(roleAuth); // 这里会把user重复的信息合并掉！！！
			}
		}
	}
	
	
	private Object getFieldValue(CIPUserProfileData userProfile,
			String column) {
		try {
			Field f = CIPUserProfileData.class.getField(column);
			return f.get(userProfile);
		} catch (Exception e) {
			return null;
		} 
	}

	//3.0.1 初始化用户权限位
	public void initUserColumns(){
		
		List<CIP_admin_auth_userPO> userConfs = authUserDao.getAll();
		CIP_admin_auth_userPO userConf;
		int size = userConfs.size();
		authUserColumns = new HashMap<String,String>(size);
		for( int i=0 ; i<size ; i++ ){
			userConf = userConfs.get(i);
			authUserColumns.put(userConf.getUser_attr_id(), userConf.getAuth_attr_name());
		}
	}
	
	//3.0.2 初始化角色权限值配置
	public void initRoleAuth(){
		String roleId = null;
		List<CIP_admin_auth_rolePO> roleConfs = authRoleDao.getAll();
		roleAuths =  new HashMap<String,Map<String,String>>();
		Map<String,String> attrs = null;
		for(CIP_admin_auth_rolePO roleConf:roleConfs){
			if(!roleConf.getAuth_role_id().equals(roleId)){
				roleId = roleConf.getAuth_role_id();
				attrs = new HashMap<String,String>();
				roleAuths.put(roleId, attrs);
			}
			attrs.put(roleConf.getAuth_attr_id(), roleConf.getAuth_attr_val());
		}
	}
	
	public void logoutUserAuth(String userId){
		mUsers.remove(userId);
		userRoles.remove(userId);
		userAuths.remove(userId);
	}
	
	//3.1访问控制
	public synchronized CIPErrorCode checkAccess(CIPUser loginUser, String resourceId, String resourceUri){
		
		//此处暂时只有本地校验
		if("index".equals(resourceId)){
			//检查uri
			if( !resourceUri.endsWith("index.html")){
				return CIPErrorCode.ERROR_INVALID_AUTHORIZATION;
			}
		}
		else if(resourceId!=null){
			List<String> userRoles = loginUser.getUserRoles();
			Map<String,String> authResources;
			boolean xNotAuth = true;
			String actionUrl = null;
			for(String userRole:userRoles){
				authResources = mAuthResources.get(userRole);
				if(authResources == null)
					break;
				actionUrl = authResources.get(resourceId);
				if(actionUrl!=null && resourceUri.endsWith(actionUrl)){
					xNotAuth = false;
					break;
				}
			}
			
			if(xNotAuth){
				return CIPErrorCode.ERROR_INVALID_AUTHORIZATION;
			}
		}
		else {
			return CIPErrorCode.ERROR_INVALID_AUTHORIZATION;
		}
		
		return null;
	}
	
	//3.2行为控制 ---- 这里要采用并行处理，否则会有性能瓶颈
	public synchronized boolean checkBehavior(String actionId, CIPAuthLock lock){
		//2. 检查属性
		CIPRuntimeOperator operator = CIPRuntime.getOperateSubject();
		String userId = operator.getSubject_id();
		Map<String,String> userAuth = userAuths.get(userId);
		
		String objectId = lock.getObjectId();
		CIPAuthObject authObject = authObjects.get(objectId);
		CIPAuthKey authKey = authObject.getKey();
		
		//a、获取当前用户对应的配置信息
		List<String> roles = userRoles.get(userId); 
		List<CIP_admin_auth_act2objPO> action2Objs = null;
		CIP_admin_auth_act2objPO action2Obj;
		int size;
		String valSrcType;
		String attrId;
		String attrValue;
		CIP_admin_rolesPO rolePO = null;
		Map<String,Object> conditions = new HashMap<String,Object>(3);
		for( String role: roles ){
			rolePO = mRoles.get(role);
			conditions.put(CIPAuthConstants.AUTH_OBJ_ID, objectId);
			conditions.put(CIPAuthConstants.AUTH_RESOURCE_ID, actionId);
			conditions.put(CIPAuthConstants.AUTH_ROOT_NODE_ID, rolePO.getRoot_resource_id());
			action2Objs = auth2ObjDao.getByCondtion(conditions);
			if( action2Objs != null){
				size = action2Objs.size();
				for(int i=0;i<size;i++){
					action2Obj = action2Objs.get(i);
					attrId = action2Obj.getObj_attr_id();
					authKey.setAuthValue(attrId, action2Obj.getAttr_value());
					valSrcType = action2Obj.getVal_src_type();
					if(valSrcType.equals(CIPAuthConstants.C_AUTH_ATTR_SRC_ROLE)){
						attrValue = roleAuths.get(role).get(attrId);
						authKey.setAuthValue(attrId, attrValue);
					}
					else if(valSrcType.equals(CIPAuthConstants.C_AUTH_ATTR_SRC_USER)){
						attrValue = userAuth.get(attrId);
						authKey.setAuthValue(attrId, attrValue);
					}
				}
				
				if(matchKey2Lock(authKey,lock)){
					return true;
				}
				authKey.clear();
			}
		}
		
		return false;
	}
	

	public void initRoles(){
		List<CIP_admin_rolesPO> roles = roleDao.getAll();
		for(CIP_admin_rolesPO role:roles){
			mRoles.put(role.getRole_id(), role);
		}
	}
	
	public void initAuthObject(){
		//设置后台所有配置的权限对象
		List<CIP_admin_auth_objPO> objects = authObjDao.getAll();
		List<CIP_admin_auth_attrPO> attrs = null;
		CIP_admin_auth_attrPO attr;
		CIPAuthObject authObj = null;
		Map<String, String> attributes;
		String objId = null;
		int size;
		Map<String,Object> conditions = new HashMap<String,Object>(1);
		for(CIP_admin_auth_objPO obj:objects ){
			objId = obj.getAuth_obj_id();
			authObj = new CIPAuthObject(objId,obj.getAuth_obj_name());
			conditions.put("obj_id", objId);
			attrs = authAttrDao.getByCondtion(conditions);//authBehaviorConfDao.getObjectAttributesConf(objId);
			if(attrs==null)
				continue;
			size = attrs.size();
			attributes = new HashMap<String, String>(size);
			for(int i=0 ; i<size; i++){
				attr = attrs.get(i);
				attributes.put(attr.getObj_attr_id(), attr.getObj_attr_name());
			}
			authObj.setAttributes(attributes);
			authObjects.put(objId, authObj);
		}
	}
	
	public synchronized CIPAuthLock getAuthLock(String objectId){
		CIPAuthObject authObject = authObjects.get(objectId);
		if( authObject != null ){
			return authObject.getLock();
		}
		else {
			return null;
		}
	}
	
	private boolean matchKey2Lock(CIPAuthKey key, CIPAuthLock lock){
		Map<String,String> lockAttrs = lock.getAuthValues();
		Map<String,String> keyAttrs = key.getAuthValues();
		
		Set<String> keys = lockAttrs.keySet();
		String lockV;
		String keyV;
		for(String k:keys){
			lockV = lockAttrs.get(k);
			if(lockV==null)
				continue;
			if(lockV.equals(""))
				return false;//权限字段，不允许填写空值
			
			keyV = keyAttrs.get(k);
			if(keyV == null || keyV.indexOf(lockV)==-1){
				return false;
			}
		}
		
		return true;
	}
	
	
	//4.系统授权
	public boolean checkAuthCode(String authCode, String srcSystemId, String srcIp){
		
		return true;
	}
	
	//5.获取查询授权信息
	public List<CIPCondition> getSearchAuth(CIPResource resource){
		
		return null;
	}

	//6. 获取用户概要信息
	public CIPUserProfileData getUserProfile(String userId) {
		return mUsers.get(userId);
	}
	
	//7. 获取用户角色信息
	public List<String> getUserRole(String userId) {
		//TODO
		return null;
	}

	public void reloadResources() {
		if(mAuthResources == null )
			return;
		
		String resourceId;
		String temp;
		int pos;
		int size;
		CIP_admin_rolesPO rolePO;
		List<CIPRole2ResourceData> resourceDBs;
		CIPRole2ResourceData resourceDB;
		Map<String,String> authResources;
		
		Set<String> roles = mRoles.keySet();
		for(String role:roles){
			rolePO = mRoles.get(role);
			resourceId = rolePO.getRoot_resource_id();
			resourceDBs = role2ResDao.getResources(resourceId);
			if(resourceDBs == null)
				continue;
			
			size = resourceDBs.size();
			authResources = new HashMap<String, String>(size);

			for(int i=0;i<size;i++){
				resourceDB = resourceDBs.get(i);
				temp = resourceDB.getSys_uri();
				if(temp == null || temp.equals(""))
					continue;
				pos = temp.indexOf('?');
				if( pos != -1)
					temp = temp.substring(0,pos);

				authResources.put(resourceDB.getResource_id(),temp);
			}
			
			//缓存用于访问权限检查filter
			mAuthResources.put(role, authResources);
		}
	}

	public void reloadResources(String userRole) {
		if (mAuthResources.get(userRole) == null) {
			// 本地角色与资源关联信息
			CIP_admin_rolesPO role = roleDao.getSingle(userRole);
			String resourceId = role.getRoot_resource_id();
			List<CIPRole2ResourceData>  resourceDBs = role2ResDao.getResources(resourceId);

			int size = resourceDBs.size();
			Map<String,String> authResources = new HashMap<String, String>(size);
			CIPRole2ResourceData resourceDB;
			String temp;
			int pos;
			for(int i=0;i<size;i++){
				resourceDB = resourceDBs.get(i);
				temp = resourceDB.getSys_uri();
				if(temp == null || temp.equals(""))
					continue;
				pos = temp.indexOf('?');
				if( pos != -1)
					temp = temp.substring(0,pos);

				authResources.put(resourceDB.getResource_id(),temp);
			}
			
			//缓存用于访问权限检查filter
			mAuthResources.put(userRole, authResources);
		}
	}
	
}
