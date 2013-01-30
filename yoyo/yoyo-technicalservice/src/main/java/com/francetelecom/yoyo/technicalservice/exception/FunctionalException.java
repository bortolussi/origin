package com.francetelecom.yoyo.technicalservice.exception;

import java.io.Serializable;

/**
 * generic class for all functional exceptions. Functional exceptions must be checked exceptions
 * @author Clara
 *
 */
public class FunctionalException extends Exception implements Serializable {

	private static final long serialVersionUID = 7552671441723224932L;

	protected String localisationClass;
	protected String localisationMethod;

		public FunctionalException() {
			super();
			localisationClass = "";
	        localisationMethod = "";
		}

		public FunctionalException(String message) {
			super(message);
			localisationClass = "";
	        localisationMethod = "";
		}

		public FunctionalException(String message, Throwable cause) {
			super(message, cause);
			localisationClass = "";
	        localisationMethod = "";
		}

		public FunctionalException(Throwable cause) {
			super(cause);
			localisationClass = "";
	        localisationMethod = "";
		}

		public FunctionalException(String clazz, String method, String message) {
			super(message);
			localisationClass = clazz;
	        localisationMethod = method;
		}

		public FunctionalException(String clazz, String method, String message, Throwable cause) {
			super(message, cause);
			localisationClass = clazz;
	        localisationMethod = method;
		}

	    public String getLocalisationClasse()
	    {
	        return localisationClass;
	    }

	    public String getLocalisationMethod()
	    {
	        return localisationMethod;
	    }

	    public String getLocalisation()
	    {
	        return localisationClass + "." + localisationMethod;
	    }

	}
