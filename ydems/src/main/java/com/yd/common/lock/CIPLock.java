package com.yd.common.lock;

import java.io.Serializable;

public class CIPLock implements Serializable {
	private static final long serialVersionUID = 7799480804041638466L;

private String lockId;//锁定对象ID
	
	private boolean isLocked = false;//是否处于锁定状态
	
	private long startLockTime=-999999;//开始锁定时间
	
	private String lockedIP=""; //执行锁定操作的主机IP地址
	
	private long lockedThreadId=-999999;//执行锁定操作的线程ID

	private long maxLockedTime = 1000*30;//最大锁定时间，设置为30s
	
	private String userId = null;


	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getStartLockTime() {
		return startLockTime;
	}

	public void setStartLockTime(long startLockTime) {
		this.startLockTime = startLockTime;
	}

	public long getMaxLockedTime() {
		return maxLockedTime;
	}

	public void setMaxLockedTime(long maxLockedTime) {
		this.maxLockedTime = maxLockedTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public String getLockId() {
		return lockId;
	}

	public void setLockId(String lockId) {
		this.lockId = lockId;
	}

	public String getLockedIP() {
		return lockedIP;
	}

	public void setLockedIP(String lockedIP) {
		this.lockedIP = lockedIP;
	}

	public long getLockedThreadId() {
		return lockedThreadId;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public void setLockedThreadId(long lockedThreadId) {
		this.lockedThreadId = lockedThreadId;
	}


}
