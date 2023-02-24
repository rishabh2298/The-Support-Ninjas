package com.masai.app.exception;

public class IssueNotFoundException extends RuntimeException {

	
	public IssueNotFoundException() {
		
	}
	
	
	public IssueNotFoundException(String message) {
		super(message);
	}
	
}
