package com.masai.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.LogInException;
import com.masai.app.model.Admin;
import com.masai.app.model.CurrentLogInSession;
import com.masai.app.model.Customer;
import com.masai.app.model.LogIn;
import com.masai.app.model.Operator;
import com.masai.app.repository.AdminRepository;
import com.masai.app.repository.CurrentLogInSessionRepository;
import com.masai.app.repository.CustomerRepository;
import com.masai.app.repository.OperatorRepository;
//import net.bytebuddy.utility.RandomString;

@Service
public class LogInServiceImpl implements LogInService {

	
	@Autowired
	private CurrentLogInSessionRepository currentLogInSessionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OperatorRepository operatorRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	
	
	
	
	// to generate unique key
	
	private String generateUniqueUUID(int N) {
		
		String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"@#$%^&*()_+"+"abcdefghijklmnopqrstuvwxyz";
		
		
		StringBuilder uuid = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			
			int index = (int)(alphaNumeric.length() * Math.random());
			
			uuid.append(alphaNumeric.charAt(index));
		}
		
		return uuid.toString();
	}
	
	
	
	@Override
	public String userLogIn(LogIn logInDTO) throws LogInException {
		
		// to check user already loggedIn or not
		if(logInDTO.getIsActive()) throw new LogInException("This "+logInDTO.getUserType().toString()+" is already Logged In");
		
		// check by email for session logIn
		CurrentLogInSession currentUser = currentLogInSessionRepository.findByUserName(logInDTO.getUserName());
		if(currentUser!=null) throw new LogInException("This "+logInDTO.getUserType().toString()+" is already Logged In");
		
		
		// So not loggIN yet
		// for different userType
		
		if(logInDTO.getUserType().toString().equals("CUSTOMER")) {
			
			// check user-id	
			Customer customer = customerRepository.findByEmail(logInDTO.getUserName());
			if(customer==null) throw new LogInException("Please Enter Correct UserName");
			
			// check user-password
			if(!customer.getPassword().equals(logInDTO.getPassword())) throw new LogInException("Please Enter correct Password");
		
			// making unique loggIn session
			CurrentLogInSession currentLogInSession = new CurrentLogInSession();
			currentLogInSession.setUserName(logInDTO.getUserName());
			currentLogInSession.setPassword(logInDTO.getPassword());
			
			String uuid = generateUniqueUUID(6);
			
			currentLogInSession.setUuid(uuid);

			CurrentLogInSession logInSession = currentLogInSessionRepository.save(currentLogInSession);
			
			// set activation
			logInDTO.setIsActive(true);
			
			
			return "Logg-In Successfull ! "+logInSession.toString();
			
		}
		else if (logInDTO.getUserType().toString().equals("ADMIN")) {

			// check user-id	
			Admin admin = adminRepository.findByEmail(logInDTO.getUserName());
			if(admin==null) throw new LogInException("Please Enter Correct UserName");
			
			// check user-password
			if(!admin.getPassword().equals(logInDTO.getPassword())) throw new LogInException("Please Enter correct Password");
		
			// making unique loggIn session
			CurrentLogInSession currentLogInSession = new CurrentLogInSession();
			currentLogInSession.setUserName(logInDTO.getUserName());
			currentLogInSession.setPassword(logInDTO.getPassword());
			
			String uuid = generateUniqueUUID(6);
			
			currentLogInSession.setUuid(uuid);

			CurrentLogInSession logInSession = currentLogInSessionRepository.save(currentLogInSession);
			
			// set activation
			logInDTO.setIsActive(true);
			
			
			return "Logg-In Successfull ! "+logInSession.toString();
			
		}
		else if (logInDTO.getUserType().toString().equals("OPERATOR")) {

			// check user-id	
			Operator operator = operatorRepository.findByEmail(logInDTO.getUserName());
			if(operator==null) throw new LogInException("Please Enter Correct UserName");
			
			// check user-password
			if(!operator.getPassword().equals(logInDTO.getPassword())) throw new LogInException("Please Enter correct Password");
		
			// making unique loggIn session
			CurrentLogInSession currentLogInSession = new CurrentLogInSession();
			currentLogInSession.setUserName(logInDTO.getUserName());
			currentLogInSession.setPassword(logInDTO.getPassword());
			
			String uuid = generateUniqueUUID(6);
			
			currentLogInSession.setUuid(uuid);
			
			CurrentLogInSession logInSession = currentLogInSessionRepository.save(currentLogInSession);
			
			// set activation
			logInDTO.setIsActive(true);
			
			return "Logg-In Successfull ! "+logInSession.toString();
			
		}
		else {
			throw new LogInException("User Type Not Found....");
		}
		
	}

	
	
	@Override
	public String userLogOut(LogIn logInDTO , String key) throws LogInException {
		
		CurrentLogInSession currentUser = currentLogInSessionRepository.findByUuid(key);
		
		if(currentUser==null) throw new LogInException("Please enter correct key to LoggOut....");
		

//		CurrentLogInSession logInSession = currentLogInSessionRepository.findByUuid(key);
//		if(logInSession==null) throw new LogInException("Please Enter correct Key");
		
	
		currentLogInSessionRepository.delete(currentUser);
		
		logInDTO.setIsActive(false);
		
		return "User ="+logInDTO.getUserName()+" is Logged-Out successfully";
	}

}
