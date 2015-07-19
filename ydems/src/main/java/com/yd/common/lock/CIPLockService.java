package com.yd.common.lock;


public interface CIPLockService {
//	public List<CIPLock> getLocks(String userId); 缓存控制台实现，这里不实现
	
	public boolean lock(CIPLock lock);
	public boolean unLock(CIPLock lock);
}
