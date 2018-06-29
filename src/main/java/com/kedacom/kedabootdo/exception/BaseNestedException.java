package com.kedacom.kedabootdo.exception;

import org.springframework.util.StringUtils;

/**
 * 
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
public class BaseNestedException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	
	/**
	 * 描述
	 */
	private String desc;
	
	/**
	 * 
	 */
	public BaseNestedException(){
	    
	}
	/**
	 * 初始化方法
	 * @param message
	 */
	public BaseNestedException(String message) {
		super(message);
	}
	
	/**
	 * 初始化
	 * @param th
	 */
	public BaseNestedException(Throwable th) {
		super(null, th);
	}
	
	/**
	 * 初始化
	 * @param message
	 * @param th
	 */
	public BaseNestedException(String message, Throwable th) {
		super(message, th);
	}
	
	/**
	 * 初始化
	 * @param message
	 * @param desc
	 */
	public BaseNestedException(String message, String desc) {
		super(message);
		this.desc = desc;
	}
	
	/**
	 * 初始化
	 * @param message
	 * @param desc
	 * @param th
	 */
	public BaseNestedException(String message, String desc, Throwable th) {
		super(message, th);
		this.desc = desc;
	}

	/**
	 * 获取message
	 */
	public String getMessage() {
	    String message = super.getMessage();
		Throwable cause = getCause();
		if (!StringUtils.hasText(message) && cause != null) {
			return cause.getMessage();
		}
		return message;
	}

	/**
	 * setter of desc
	 * @return
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * getter of desc
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}

