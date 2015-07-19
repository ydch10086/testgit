package com.yd.common.exception;

import com.yd.common.runtime.CIPErrorCode;

/**
 * DAO层异常
 * @author Rong.zhu
 *
 */
public class CIPDaoException extends RuntimeException {
	
	private static final long serialVersionUID = -8911841526915972592L;
	
	private CIPErrorCode errorCode = null;
	public CIPDaoException(CIPErrorCode error) {
		super(error.name);
		errorCode = error;
	}
	
	public CIPDaoException(Throwable cause) {
		super(cause);
	}
	
	public CIPDaoException(CIPErrorCode error, Throwable cause) {
		super(error.name, cause);
		errorCode = error;
	}
	
	
	
	public CIPErrorCode getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		if(super.getCause()==null) {
			return super.getMessage();
		}else {
			return super.getMessage() + ", nested exception is " + super.getCause().toString();
		}
	}
}
