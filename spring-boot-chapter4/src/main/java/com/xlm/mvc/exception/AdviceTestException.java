/**
 * 2017年10月19日
 */
package com.xlm.mvc.exception;

/**
 * @author XIXI
 *
 */
public class AdviceTestException extends RuntimeException {
	private Class<?> exceptionClass;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return the exceptionClass
	 */
	public Class<?> getExceptionClass() {
		return exceptionClass;
	}

	/**
	 * 
	 */
	public AdviceTestException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AdviceTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AdviceTestException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AdviceTestException(String message,Class<?> exceptionClass) {
		super(message);
		this.exceptionClass = exceptionClass;
	}

	/**
	 * @param cause
	 */
	public AdviceTestException(Throwable cause) {
		super(cause);
	}
	

}
