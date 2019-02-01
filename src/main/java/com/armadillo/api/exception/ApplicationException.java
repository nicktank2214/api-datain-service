package com.armadillo.api.exception;


public class ApplicationException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	
	private ExceptionResponse exceptionResponse;
	
	
	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);	
	}

	public ApplicationException(String message, ExceptionResponse exceptionResponse) {
		super(message);	
		this.exceptionResponse=exceptionResponse;
	}

	
	
	public ExceptionResponse getExceptionResponse() {
		return exceptionResponse;
	}

	public void setExceptionResponse(ExceptionResponse exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}
	
	
	
}