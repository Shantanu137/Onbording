package com.cts.exception;


public class AssociateAlreadyExistException extends RuntimeException {
	private String message;
	private static final long serialVersionUID = 1L;

	public AssociateAlreadyExistException(String msg) {
		super(msg);
		this.message = msg;
	}

}
