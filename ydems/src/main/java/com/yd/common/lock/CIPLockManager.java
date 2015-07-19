package com.yd.common.lock;

import java.net.InetAddress;

import com.yd.common.runtime.CIPRuntime;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.runtime.CIPRuntimeOperator;

public class CIPLockManager {
	
	private static CIPLockService lockService = null;
	
	static{
		lockService = new CIPLockServiceImpl();
	}
	
	private static CIPLock getLock(String lockId) throws Exception{
		CIPLock lock = new CIPLock();
		lock.setLockId(lockId);
		String ip = InetAddress.getLocalHost().getHostAddress();// 当前服务器IP
		long threadId = Thread.currentThread().getId();// 当前线程ID
		lock.setLockedIP(ip);
		lock.setLockedThreadId(threadId);
		lock.setStartLockTime(System.currentTimeMillis());
		CIPRuntimeOperator operator = CIPRuntime.getOperateSubject();
		lock.setUserId(operator.getSubject_id());
		
		return lock;
	}
	
	public static boolean lockSystem(){
		
		try {
			CIPLock lock = getLock("lock_system@"+CIPRuntimeConfigure.cip_system_id);
			return lockService.lock(lock);
		} catch (Exception e) {
			return false;
		}

	}
	
	public static boolean lockResource(String resourceId){
		try {
			CIPLock lock = getLock("lock_resource@"+resourceId);
			return lockService.lock(lock);
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean lockFunction(String resourceId, String functionId){
		try {
			CIPLock lock = getLock("lock_function@"+resourceId+"_"+functionId);
			return lockService.lock(lock);
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean lockEntity(String entityId){
		try {
			CIPLock lock = getLock("lock_entity@"+entityId);
			return lockService.lock(lock);
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean unlockSystem(){
		try {
			CIPLock lock = getLock("lock_system@"+CIPRuntimeConfigure.cip_system_id);
			return lockService.unLock(lock);
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean unlockResource(String resourceId){
		try {
			CIPLock lock = getLock("lock_resource@"+resourceId);
			return lockService.unLock(lock);
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean unlockFunction(String resourceId, String functionId){
		try {
			CIPLock lock = getLock("lock_function@"+resourceId+"_"+functionId);
			return lockService.unLock(lock);
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean unlockEntity(String entityId){
		try {
			CIPLock lock = getLock("lock_entity@"+entityId);
			return lockService.unLock(lock);
		} catch (Exception e) {
			return false;
		}
	}
}
