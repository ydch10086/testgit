package com.yd.common.cache;

import org.apache.log4j.Logger;

import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.utils.JSONUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;


public class RemoteCacheManager implements CIPCacheService {
	private Logger log = Logger.getLogger(RemoteCacheManager.class);

	@Override
	public void set(String key, Object data, boolean setExpireTime){
		if(data == null) return;
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try{
			jedis = CIPRedisUtils.getJedisResource();
			jedis.set(key.getBytes("UTF-8"), JSONUtils.convertObject2Json(data).getBytes("UTF-8"));
			if(setExpireTime && CIPRedisUtils.expireTime >0) {//设置过期时间
				jedis.expire(key.getBytes("UTF-8"), CIPRedisUtils.expireTime);
			}
		}catch(JedisConnectionException e) {
			log.error(e.getMessage());
			isJedisConnectExceptionOccured = true;
			throw new CIPRuntimeException(CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new CIPRuntimeException(CIPErrorCode.ERROR_TECHNICAL_ERROR, e);
		}finally{
			CIPRedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured); //释放jedis到池中
		}
	}
	
	@Override
	public <T>T get(String key, Class<T> clazz){
		T object = null; 
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try{
			jedis = CIPRedisUtils.getJedisResource();
			byte[] bytes = jedis.get(key.getBytes("UTF-8"));
			if(bytes != null){
				String value = new String(bytes,"UTF-8");
				object = (T)JSONUtils.convertJson2Object(value, clazz);
			}
		}catch(JedisConnectionException e) {
			log.error(e.getMessage());
			isJedisConnectExceptionOccured = true;
			throw new CIPRuntimeException(CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new CIPRuntimeException(CIPErrorCode.ERROR_TECHNICAL_ERROR, e);
		}finally{
			CIPRedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured); //释放jedis到池中
		}
		return object;
	}

	@Override
	public void hashset(String key, String field, Object data, boolean setExpireTime){
		if(data == null) return;
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try{
			jedis = CIPRedisUtils.getJedisResource();
			jedis.hset(key.getBytes("UTF-8"),field.getBytes("UTF-8"), JSONUtils.convertObject2Json(data).getBytes("UTF-8"));
			if(setExpireTime && CIPRedisUtils.expireTime >0) {
				jedis.expire(key.getBytes("UTF-8"), CIPRedisUtils.expireTime);//设置过期时间
			}
		}catch(JedisConnectionException e) {
			log.error(e.getMessage());
			isJedisConnectExceptionOccured = true;
			throw new CIPRuntimeException(CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new CIPRuntimeException(CIPErrorCode.ERROR_TECHNICAL_ERROR, e);
		}finally{
			CIPRedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured); //释放jedis到池中
		}
		
	}
	@Override
	public <T> T hashget(String key, String field, Class<T> clazz){
		T object = null; 
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try{
			jedis = CIPRedisUtils.getJedisResource();
			byte[] bytes = jedis.hget(key.getBytes("UTF-8"), field.getBytes("UTF-8"));
			if(bytes != null){
				String value = new String(bytes,"UTF-8");
				object = (T)JSONUtils.convertJson2Object(value, clazz);
			}
		}catch(JedisConnectionException e) {
			log.error(e.getMessage());
			isJedisConnectExceptionOccured = true;
			throw new CIPRuntimeException(CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new CIPRuntimeException(CIPErrorCode.ERROR_TECHNICAL_ERROR, e);
		}finally{
			CIPRedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured); //释放jedis到池中
		}
		return object;
	}
	
	
	@Override
	public void remove(String key){
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try{
			jedis = CIPRedisUtils.getJedisResource();
		}catch(JedisConnectionException e) {
			log.error(e.getMessage());
			isJedisConnectExceptionOccured = true;
			throw new CIPRuntimeException(CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new CIPRuntimeException(CIPErrorCode.ERROR_TECHNICAL_ERROR, e);
		}finally{
			CIPRedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured); //释放jedis到池中
		}
	}

	@Override
	public void clear(){
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try{
			jedis = CIPRedisUtils.getJedisResource();
			jedis.flushDB(); //清除缓存数据
			
		}catch(JedisConnectionException e) {
			log.error(e.getMessage());
			isJedisConnectExceptionOccured = true;
			throw new CIPRuntimeException(CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new CIPRuntimeException(CIPErrorCode.ERROR_TECHNICAL_ERROR, e);
		}finally{
			CIPRedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured); //释放jedis到池中
		}
		
	}

}
