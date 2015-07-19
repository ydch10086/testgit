package com.yd.common.lock;

import com.yd.common.cache.CIPCacheManager;
import com.yd.common.cache.CIPCacheService;

public class CIPLockServiceImpl implements CIPLockService {

	private CIPCacheService cache = CIPCacheManager.getCacheService();

	@Override
	public boolean lock(CIPLock lock) {
		boolean hasLockPrivilege = false;
		String key = lock.getLockId();
		synchronized (key) {

			CIPLock lock0 = cache.get(key, CIPLock.class);
			if (lock0 == null || !lock0.isLocked()) {
				// 不存在或者处于未锁定状态则当前线程能够对其加锁
				hasLockPrivilege = true;

			} else {
				// 存在且处于锁定状态则判断当前线程能否加锁

				String userId = lock0.getUserId();
				if (userId.equals(lock.getUserId())) {
					String lockedIp = lock0.getLockedIP();
					long lockedThreadId = lock0.getLockedThreadId();
					if (lockedIp.equals(lock.getLockedIP())
							&& lock.getLockedThreadId() == lockedThreadId) {
						// 1.
						// IP和线程ID都相同，则表示该对象锁是由当前线程锁定的，允许继续上锁(这样做是为了确保一笔交易的多次操作都够执行完成)
						hasLockPrivilege = true;
					} else {
						if (lock.getStartLockTime() - lock0.getStartLockTime() > lock0
								.getMaxLockedTime()) {
							// 2. 超过最大锁定时间，则允许其他线程访问并上锁
							hasLockPrivilege = true;
						}
					}
				}
			}

			if (hasLockPrivilege) {// 锁定后更新到缓存中
				if (lock0 == null) {
					lock0 = lock;
				}
				lock0.setLocked(true);
				cache.set(key, lock0, false);

			}
		}
		return hasLockPrivilege;
	}

	@Override
	public boolean unLock(CIPLock lock) {
		String key = lock.getLockId();
		boolean hasUnlockPrivilege = false;
		synchronized (key) {
			CIPLock lock0 = cache.get(key, CIPLock.class);

			if(lock0 == null || lock0.isLocked() == false) {//无需解锁直接返回true
				return true;
			}
			String userId = lock0.getUserId();
			if( userId == null || userId.equals(lock.getUserId())){
				String ip = lock.getLockedIP();
				long threadId = lock.getLockedThreadId();
				if(lock0.getLockedIP().equals(ip) && lock0.getLockedThreadId()==threadId) {
					//当前线程IP和ID均与锁的IP和ID相同，则允许解锁
					hasUnlockPrivilege = true;
				}else if(System.currentTimeMillis() - lock0.getStartLockTime() > lock0.getMaxLockedTime()) {
					//超时了允许解锁
					hasUnlockPrivilege = true;
				}
			}
			
			
			if(hasUnlockPrivilege) {
				lock.setLocked(false);
				lock.setLockedIP("");
				lock.setLockedThreadId(-999999);
				lock.setStartLockTime(-999999);
				cache.set(key,  lock, false);
			}
		}
		
		return hasUnlockPrivilege;
	}

}
