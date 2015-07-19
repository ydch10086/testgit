package com.yd.common.cache;

import java.util.HashMap;
import java.util.Map;

import com.yd.common.utils.JSONUtils;


public class LocalCacheManager implements CIPCacheService{
	
	private static Map<String, String> commonCache = new HashMap<String, String>();
	
	private static Map<String, Map<String, String>> hashCache = new HashMap<String, Map<String, String>>();
	
	@Override
	public void set(String key, Object data, boolean setExpireTime){
		if(hashCache.containsKey(key)) {
			hashCache.remove(key);
		}
		String value = JSONUtils.convertObject2Json(data);
		commonCache.put(key, value);
	}
	
	@Override
	public <T> T get(String key, Class<T> clazz) {
		String value = commonCache.get(key);
		return value==null ? null : (T)JSONUtils.convertJson2Object(value, clazz);
	}

	@Override
	public void hashset(String key, String field, Object data, boolean setExpireTime){
		if(commonCache.containsKey(key)) {
			commonCache.remove(key);
		}
		
		String value = JSONUtils.convertObject2Json(data);
		Map<String, String> fieldMap = hashCache.get(key);
		if(fieldMap == null) 
			fieldMap = new HashMap<String, String>();
		fieldMap.put(field, value);
		hashCache.put(key, fieldMap);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
	}

	@Override
	public <T> T hashget(String key, String field, Class<T> clazz){
		Map<String, String> fieldMap = hashCache.get(key);
		if(fieldMap == null) 
			return null;
		String value = fieldMap.get(field);
		return value==null ? null : (T)JSONUtils.convertJson2Object(value, clazz);
	}
	
	@Override
	public void remove(String key){
		if(commonCache.containsKey(key)) {
			commonCache.remove(key);
		}else if(hashCache.containsKey(key)) {
			hashCache.remove(key);
		}
	}

	@Override
	public void clear(){
		commonCache.clear();
		hashCache.clear();
		
	}
	

}
