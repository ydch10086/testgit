package com.yd.common.exception;

import com.yd.common.runtime.CIPErrorCode;

public class CIPRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private CIPErrorCode errorCode;
	
	public CIPErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(CIPErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public CIPRuntimeException(CIPErrorCode errorCode) {
		this.errorCode = errorCode;
		
	}

	public CIPRuntimeException(CIPErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		
	}

}
