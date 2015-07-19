package com.yd.common.exception;

import com.yd.common.runtime.CIPErrorCode;

public class CIPServiceException extends RuntimeException {
	private static final long serialVersionUID = -8911841526915972591L;
	
	public CIPServiceException(CIPErrorCode msg) {
		super(msg.name);
		this.errorCode = msg;
	}
	
	public CIPServiceException(Throwable cause) {
		super(cause);
	}
	
	public CIPServiceException(CIPErrorCode msg, Throwable cause) {
		super(msg.name, cause);
		this.errorCode = msg;
	}
	
	private CIPErrorCode errorCode;
	
	
	public CIPErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(CIPErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		if(super.getCause()==null) {
			return super.getMessage();
		}else {
			return super.getMessage() + ", nested exception is " + super.getCause().toString();
		}
	}
}
