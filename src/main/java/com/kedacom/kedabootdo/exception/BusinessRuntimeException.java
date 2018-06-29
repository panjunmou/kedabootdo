package com.kedacom.kedabootdo.exception;

/**
 * 
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
public class BusinessRuntimeException extends BaseNestedException {

	private static final long serialVersionUID = 1L;

	public BusinessRuntimeException() {
	}

	/**
	 * 
	 * @param message
	 */
	public BusinessRuntimeException(String message) {
		super(message);
	}

	public BusinessRuntimeException(Throwable th) {
		super(th);
	}

	public BusinessRuntimeException(String message, Throwable th) {
		super(message, th);
	}

	public BusinessRuntimeException(String message, String desc) {
		super(message, desc);
	}

	public BusinessRuntimeException(String message, String desc, Throwable th) {
		super(message, desc, th);
	}

}

