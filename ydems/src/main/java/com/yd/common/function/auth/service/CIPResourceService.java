package com.yd.common.function.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yd.common.auth.CIPResource;
import com.yd.common.session.CIPUser;

@Service
public interface CIPResourceService {
	//3.用户初始权限资源获取
	public List<CIPResource> getResources(CIPUser user);
	
	//用户行为权限资源获取
	public List<CIPResource> getResources(CIPUser user, String resourceId);

	//初始化访问资源
	public void initResource(String userRole);
	
	//重加载系统资源
	public void reloadResources();
}
