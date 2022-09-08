package com.exception;

public class jobIdNotFoundException extends Exception{
	private String message;

	public jobIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public jobIdNotFoundException() {
		super();
	}
	
}
