package com.waiyanhtet.exception;

public class StudentAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentAlreadyExistException(String message) {
		super(message);
	}

	
}
