package com.kedacom.kedabootdo.exception;


/**
 *      业务异常类。对违反业务逻辑的操作抛出这个异常。这属于EJB规范
 * 中的应用级异常。<br>
 *     这类异常应由操作员判断如何处理，因此BO类不应捕获这类异常，而
 * 应直接将它们转发给客户端。<br>
 *     注意：对BO类中抛出业务异常的方法，应在该BO对象的remote接口中
 * 对应方法的声明上加上对该异常的声明。 
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
public class BusinessException extends Exception {

    static final long serialVersionUID = -35466L;

    /**
     * 提示
     */
    private String hint;

    /**
     *错误码，需统一编写，包括业务插件抛出的错误
     *
     */
    private String errorCodeString = ""; 

    /**
     * BusinessException 构造子注解。
     */
    public BusinessException() {
        super();
    }

    /**
     * BusinessException 构造子注解。
     * @param s java.lang.String
     */
    public BusinessException(String s) {
        super(s);
    }

    /**
     * BusinessException 构造子注解。
     * @param s java.lang.String
     */
    public BusinessException(String s,String errorCode) {
        super(s);
        setErrorCodeString(errorCode);
    }

    /**
     * 获得引发异常的原因的提示或说明。
     * 
     * @return java.lang.String 引发异常的原因说明。
     */
    public java.lang.String getHint() {
        return hint;
    }

    /**
     * 设置对引发异常的原因的提示或说明。
     * 
     * @param newHint java.lang.String 引发异常的原因。
     */
    public void setHint(java.lang.String newHint) {
        hint = newHint;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public String getErrorCodeString() {
        return errorCodeString;
    }

    public void setErrorCodeString(String errorCode) {
        this.errorCodeString = errorCode;
    }

}

