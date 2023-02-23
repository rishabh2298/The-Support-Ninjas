package com.masai.app.exception;

public class DepartmentNotFoundException extends RuntimeException {

	
	public DepartmentNotFoundException() {
		
	}
	
	
	public DepartmentNotFoundException(String message) {
		super(message);
	}
	
}
