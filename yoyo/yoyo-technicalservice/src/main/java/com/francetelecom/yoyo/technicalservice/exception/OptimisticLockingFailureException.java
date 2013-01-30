package com.francetelecom.yoyo.technicalservice.exception;

/**
 * Technical data access exception
 * @author Clara
 *
 */
public class OptimisticLockingFailureException extends TechnicalException {

	private static final long serialVersionUID = -4390419002295148544L;

	public OptimisticLockingFailureException() {
		super();
	}

	public OptimisticLockingFailureException(String message) {
		super(message);
	}

	public OptimisticLockingFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public OptimisticLockingFailureException(Throwable cause) {
		super(cause);
	}

	public OptimisticLockingFailureException(String clazz, String method, String message) {
		super(clazz, method, message);
	}

	public OptimisticLockingFailureException(String clazz, String method, String message, Throwable cause) {
		super(clazz, method, message, cause);
	}	

}
