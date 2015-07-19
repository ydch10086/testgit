package com.yd.common.cache;


public class CIPCacheManager {
	
	/** ----远程缓存(Redis服务器)-----*/
	public static final int CACHE_SCHEMA_REMOTE = 1;
	
	/** ----本地缓存(当前应用服务器)-----*/
	public static final int CACHE_SCHEMA_LOCAL = 0;
	
	
	private static CIPCacheService cacheService = null;
	
	public static void createCacheManager(int cache_schema) {
		if(cacheService!=null)
			return;
		
		if(cache_schema == CACHE_SCHEMA_REMOTE) {
			cacheService = new RemoteCacheManager();
		}else {
			cacheService = new LocalCacheManager();
		}
	}
	
	public static CIPCacheService getCacheService(){
		return cacheService;
	}
	
}
