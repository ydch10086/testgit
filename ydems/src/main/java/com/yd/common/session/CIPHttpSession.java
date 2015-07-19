package com.yd.common.session;

import java.util.HashMap;
import java.util.Map;

import com.yd.common.cache.CIPCacheManager;
import com.yd.common.cache.CIPCacheService;
import com.yd.common.utils.JSONUtils;


/**
 * 用户会话，代替  Http session。同时支持集群和单机模式
 * @author Rong.zhu
 *
 */
public class CIPHttpSession {

	private String sessionId;
	
	private Map<String, Object> attributes = new HashMap<String, Object>();
	
	public CIPHttpSession() {}
	
	public CIPHttpSession(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public <T>T getAttribute(String key, Class<T> clazz) {
		Object value = this.attributes.get(key);//已经被json序列化成String
		return value==null ? null : (T)JSONUtils.convertJson2Object(value.toString(), clazz);
		
	}
	
	public void setAttributes(Map<String, Object> attrs) throws Exception {
		this.attributes.putAll(attrs);
		if(sessionId==null) 
			return; 
		CIPCacheService cache = CIPCacheManager.getCacheService();
		cache.set("session@" + sessionId, this, true);
	}
	
	public void setAttribute(String key, Object obj)  throws Exception {
		this.attributes.put(key, obj);
		if(sessionId==null) 
			return; 
		CIPCacheService cache = CIPCacheManager.getCacheService();
		cache.set("session@" + sessionId, this, true);
	}
	
	public void removeAttribute(String key) throws Exception {
		this.attributes.remove(key);
		if(sessionId==null) 
			return;
		CIPCacheService cache = CIPCacheManager.getCacheService();
		cache.set("session@" + sessionId, this, true);
	}
	
	public void invalidate() throws Exception {
		CIPCacheService cache = CIPCacheManager.getCacheService();
		cache.remove("session@" + sessionId);
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
}
