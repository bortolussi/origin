package com.francetelecom.yoyo.technicalservice.exception;

/**
 * Not found functional exception
 * 
 * @author Clara
 * 
 */

public class NotFoundException extends FunctionalException {

	private static final long serialVersionUID = -3041264286403948893L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(Throwable cause) {
		super(cause);
	}

	public NotFoundException(String clazz, String method, String message) {
		super(clazz, method, message);
	}

	public NotFoundException(String clazz, String method, String message, Throwable cause) {
		super(clazz, method, message, cause);
	}	
}
