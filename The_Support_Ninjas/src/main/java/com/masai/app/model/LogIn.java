package com.masai.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogIn {
	
	private String userName;
	private String password;
	private LogInType userType;
	private Boolean isActive;

}
