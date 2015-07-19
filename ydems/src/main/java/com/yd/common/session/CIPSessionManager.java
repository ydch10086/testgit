package com.yd.common.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.common.cache.CIPCacheService;
import com.yd.common.cache.CIPCacheManager;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.runtime.CIPRuntimeConstants;
import com.yd.common.utils.StringUtils;



/**
 * session管理器：
 *
 * *集群环境下从redis获取
 * 
 * *单机环境下从本机获取
 * 
 * @author Rong.zhu
 *
 */
public class CIPSessionManager {
	
	public static CIPHttpSession getSystemSession(String sessionId){
		CIPCacheService cache = CIPCacheManager.getCacheService();
		return cache.get("session@" + sessionId, CIPHttpSession.class);
	}
	
	private static CIPHttpSession systemSession = null;
	public static String initSystemSession(){
		if( systemSession != null )
			return systemSession.getSessionId();
		String sessionId = StringUtils.getUUID()+"-"+System.currentTimeMillis();
		CIPCacheService cache = CIPCacheManager.getCacheService();
		systemSession = new CIPHttpSession(sessionId);
		cache.set("session@" + sessionId, systemSession, false);
		return sessionId;
	}

	public static CIPHttpSession getSession(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		CIPHttpSession cipSession = null;
		String sessionId = null;
		//通过cookie获取sessionid
		//如果客户端不支持cookie模式，也是在这里对客户端session加强管理 TODO
		Cookie[] cookies = request.getCookies();
		if(cookies !=null && cookies.length>0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(CIPRuntimeConstants.CIP_SESSION_ID)) {
					sessionId = cookie.getValue();
					break;
				}
			}
		}
		
		CIPCacheService cache = CIPCacheManager.getCacheService();
		if(sessionId == null) {
			sessionId = StringUtils.getUUID()+"-"+System.currentTimeMillis();
		}
		else{
			cipSession = cache.get("session@" + sessionId, CIPHttpSession.class);
		}
		
		if(cipSession == null) {
			//向客户端回写cookie
			writeCookie(response, CIPRuntimeConstants.CIP_SESSION_ID, sessionId);
			
			//创建session并写入缓存中
			cipSession = new CIPHttpSession(sessionId);
			cache.set("session@" + sessionId, cipSession, true);
		}
		return  cipSession;
		
	}
	

	private static void writeCookie(HttpServletResponse response, String name, String value) throws ServletException, IOException {
		Cookie cookie = new Cookie(name, value);
		//为了安全起见，不设置会话cookie的过期时间。(默认生命周期为浏览器进程,浏览器关闭,cookie消失)
		//cookie.setMaxAge(24*60*60);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
}
