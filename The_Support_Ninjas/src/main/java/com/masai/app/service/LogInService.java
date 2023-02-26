package com.masai.app.service;

import com.masai.app.exception.LogInException;
import com.masai.app.model.LogIn;

public interface LogInService {
	
	public String userLogIn(LogIn logInDTO) throws LogInException;
	
	public String userLogOut(LogIn logInDTO, String key) throws LogInException;

}
