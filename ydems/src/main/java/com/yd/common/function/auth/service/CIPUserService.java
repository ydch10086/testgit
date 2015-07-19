package com.yd.common.function.auth.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yd.common.auth.CIPUserProfileData;
import com.yd.common.function.auth.data.CIPLoginData;
import com.yd.common.function.auth.data.CIPAuthResult;

@Service
public interface CIPUserService {

	//1 用户登录验证号
	public String getPassCode(OutputStream os) throws IOException;
	
	//2.1 用户登陆认证
	public CIPAuthResult loginUser(CIPLoginData loginData);
	
	//2.2 用户登出
	public CIPAuthResult logoutUser(CIPLoginData loginData);
		
	//3. 重置密码
	public CIPAuthResult resetPassword(String userId, String oldP, String newP);
//	
//	//4. 锁定用户
//	public int lockUser(String userId);
//	
//	//5. 解锁用户
//	public int unlockUser(String userId);
//	
	//6. 获取当前系统 用户概要
	public CIPUserProfileData getUserProfile(String userId);
	
//	//7. 获取用户全信息
//	public CIPUserData getUserData(String userId);
//	
//	//8. 修改当前系统 用户信息 
//	public int updateUser(CIPUserProfileData userData);
//	
	//9. 获取用户角色信息
	public List<String> getRoles(String userId);
}
