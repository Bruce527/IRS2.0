/**
 * 
 */
package com.sinosoft.eos.exception;

/**
 * @author Darker.Wang
 * @date 2016-7-5 上午9:53:50
 * 提数报送异常
 */
public class EOSException extends Exception{

	private String mssage = "提数报送异常";
	private Exception exception;
	private String function;
	private static final long serialVersionUID = 1L;
	public EOSException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public EOSException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EOSException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EOSException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param e
	 */
	public void setException(Exception e) {
		// TODO Auto-generated method stub
		exception = e;
	}
	public String getMssage() {
		return mssage;
	}
	/**
	 * @param string
	 */
	public void setFunction(String string) {
		// TODO Auto-generated method stub
		function = string;
	}

	public Exception getException() {
		return exception;
	}

	public String getFunction() {
		return function;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		this.mssage = message;
	}

}
