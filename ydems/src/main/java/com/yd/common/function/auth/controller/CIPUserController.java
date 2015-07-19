package com.yd.common.function.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yd.common.auth.CIPAuthManager;
import com.yd.common.auth.CIPResource;
import com.yd.common.auth.CIPUserProfileData;
import com.yd.common.data.CIPResponseMsg;
import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.function.auth.data.CIPLoginData;
import com.yd.common.function.auth.data.CIPAuthResult;
import com.yd.common.function.auth.service.CIPResourceService;
import com.yd.common.function.auth.service.CIPUserService;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntime;
import com.yd.common.runtime.CIPRuntimeConstants;
import com.yd.common.session.CIPHttpSession;
import com.yd.common.session.CIPSessionManager;
import com.yd.common.session.CIPUser;

@RestController
@RequestMapping(value = "/")
public class CIPUserController {
	@Autowired
	private CIPUserService userService;
	
	@Autowired
	private CIPResourceService resourceService;
	
	private static final String USER_PASS_CODE = "cip_passcode";

	// 登录系统
	@RequestMapping(value = "public/common/user/login")
	public CIPResponseMsg login(@RequestBody CIPLoginData user,
			HttpServletRequest request, HttpServletResponse response) {

		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			CIPHttpSession session = CIPSessionManager.getSession(request,
					response);
			user.local_pass_code = session.getAttribute(USER_PASS_CODE,
					String.class);
			CIPAuthResult returnCode = userService.loginUser(user);
			msg.errorCode = returnCode.code;
			msg.msg = returnCode.name;
			if( returnCode.code != CIPAuthResult.LOGIN_SUCCESS.code ){
				return msg;
			}

			CIPUserProfileData userData = userService
					.getUserProfile(user.user_id);
			msg.data = userData;
			
			CIPUser loginUser = new CIPUser();
			loginUser.setUserId(user.user_id);
			loginUser.setUserName(userData.user_name);
			loginUser.setOrgCode(userData.org_id);
			List<String> userRoles = userService.getRoles(user.user_id);
			loginUser.setUserRoles(userRoles);
			session.setAttribute(CIPRuntimeConstants.LOGIN_USER, loginUser);
			
			//初始化用户访问资源，用于访问检查
			for( String userRole:userRoles)
				resourceService.initResource(userRole);
			
			//初始化用户行为权限资源，用于行为检查
			CIPRuntime.authManager.initUserAuth(loginUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.errorCode = CIPErrorCode.ERROR_RESOURCE_IS_NOT_READY.code;
			msg.msg = e.getMessage();
		}

		return msg;
	}

	@RequestMapping(value = "actions/common/user/logout")
	public CIPResponseMsg logout(CIPLoginData user, HttpServletRequest request,
			HttpServletResponse response) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			CIPHttpSession session = CIPSessionManager.getSession(request,
					response);
			session.invalidate();

			CIPAuthResult returnCode = userService.logoutUser(user);
			msg.errorCode = returnCode.code;
			msg.msg = returnCode.name;
			
			CIPRuntime.authManager.logoutUserAuth(user.user_id);
		} catch (Exception e) {
			msg.errorCode = CIPErrorCode.ERROR_RESOURCE_IS_NOT_READY.code;
			msg.msg = e.getMessage();
		}

		return msg;
	}

	// 随机获取验证码
	@RequestMapping(value = "public/common/user/getPassCode")
	@ResponseBody
	public void getPassCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		CIPHttpSession session = CIPSessionManager
				.getSession(request, response);
		
		String passCode = userService.getPassCode(response.getOutputStream());
		response.flushBuffer();	
		
		// 保存passcode 到 session
		session.setAttribute(USER_PASS_CODE, passCode);
	}

	// 重置密码
	@RequestMapping(value = "actions/common/user/resetPwd")
	public CIPResponseMsg resetPwd(HttpServletRequest request,
			HttpServletResponse response) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			CIPHttpSession session = CIPSessionManager.getSession(request,
					response);
			CIPUser user = session.getAttribute(CIPRuntimeConstants.LOGIN_USER,
					CIPUser.class);
			String oldP = request.getParameter("old_pwd");
			String newP = request.getParameter("new_pwd");
			CIPAuthResult returnCode = userService.resetPassword(
					user.getUserId(), oldP, newP);
			msg.errorCode = returnCode.code;
			msg.msg = returnCode.name;
		} catch (Exception e) {
			msg.errorCode = CIPErrorCode.ERROR_RESOURCE_IS_NOT_READY.code;
			msg.msg = e.getMessage();
		}

		return msg;
	}

	// 获取用户概要信息
	@RequestMapping(value = "actions/common/user/getUserProfile")
	public CIPResponseMsg getUserProfile(HttpServletRequest request,
			HttpServletResponse response) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			CIPHttpSession session = CIPSessionManager.getSession(request,
					response);
			CIPUser user = session.getAttribute(CIPRuntimeConstants.LOGIN_USER,
					CIPUser.class);
			CIPUserProfileData userProfile = userService.getUserProfile(user
					.getUserId());
			msg.data = userProfile;
		} catch (Exception e) {
			msg.errorCode = CIPErrorCode.ERROR_RESOURCE_IS_NOT_READY.code;
			msg.msg = e.getMessage();
		}

		return msg;
	}
	
	//重新加载资源
	@RequestMapping(value = "actions/common/user/refreshResources")
	public CIPResponseMsg refreshResources(HttpServletRequest request,
			HttpServletResponse response) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			resourceService.reloadResources();
			msg.errorCode = CIPErrorCode.CALL_SUCCESS.code;
			msg.msg = CIPErrorCode.CALL_SUCCESS.name;
		}
		catch (CIPRuntimeException e) {
			msg.errorCode = e.getErrorCode().code;
			msg.msg = e.getErrorCode().name;
		}
		catch (Exception e) {
			e.printStackTrace();
			msg.errorCode = CIPErrorCode.ERROR_RESOURCE_IS_NOT_READY.code;
			msg.msg = e.getMessage();
		} 
		
		return msg;
	}
	

	// 获取用户概要信息
	@RequestMapping(value = "actions/common/user/getResources")
	public CIPResponseMsg getResources(HttpServletRequest request,
			HttpServletResponse response) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			String resource_id = request.getParameter("resource_id");
			CIPHttpSession session = CIPSessionManager.getSession(request,
					response);
			CIPUser user = session.getAttribute(CIPRuntimeConstants.LOGIN_USER,
					CIPUser.class);
			List<CIPResource> resources;
			if( resource_id == null || resource_id.equals(""))
				resources = resourceService.getResources(user);
			else 
				resources = resourceService.getResources(user, resource_id);
			
			msg.data = resources;
		}
		catch (CIPRuntimeException e) {
			msg.errorCode = e.getErrorCode().code;
			msg.msg = e.getErrorCode().name;
		}
		catch (Exception e) {
			e.printStackTrace();
			msg.errorCode = CIPErrorCode.ERROR_RESOURCE_IS_NOT_READY.code;
			msg.msg = e.getMessage();
		} 
		

		return msg;
	}

}
