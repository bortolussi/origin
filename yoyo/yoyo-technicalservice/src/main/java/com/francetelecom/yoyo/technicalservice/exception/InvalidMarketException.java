package com.francetelecom.yoyo.technicalservice.exception;

/**
 * Invalid market functional exception
 * 
 * @author Clara
 *
 */public class InvalidMarketException extends FunctionalException {

	private static final long serialVersionUID = -3041264286403948893L;

	public InvalidMarketException() {
		super();
	}

	public InvalidMarketException(String message) {
		super(message);
	}

	public InvalidMarketException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidMarketException(Throwable cause) {
		super(cause);
	}

	public InvalidMarketException(String clazz, String method, String message) {
		super(clazz, method, message);
	}

	public InvalidMarketException(String clazz, String method, String message, Throwable cause) {
		super(clazz, method, message, cause);
	}	

}
