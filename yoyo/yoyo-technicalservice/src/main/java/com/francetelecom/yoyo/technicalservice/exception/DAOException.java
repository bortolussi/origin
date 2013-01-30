package com.francetelecom.yoyo.technicalservice.exception;

/**
 * Technical data access exception
 * @author Clara
 *
 */
public class DAOException extends TechnicalException {

	private static final long serialVersionUID = -4390419002295148544L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String clazz, String method, String message) {
		super(clazz, method, message);
	}

	public DAOException(String clazz, String method, String message, Throwable cause) {
		super(clazz, method, message, cause);
	}	

}
