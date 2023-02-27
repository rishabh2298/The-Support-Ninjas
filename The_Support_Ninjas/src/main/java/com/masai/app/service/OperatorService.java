package com.masai.app.service;

import java.util.List;

import com.masai.app.exception.CallNotFoundException;
import com.masai.app.exception.CustomerNotFoundException;
import com.masai.app.exception.IssueNotFoundException;
import com.masai.app.exception.LogInException;
import com.masai.app.model.Customer;
import com.masai.app.model.Issue;
import com.masai.app.model.LogIn;

public interface OperatorService {
	
	public String logInOperator(LogIn logInDTO) throws LogInException;
	
	public String logOutOperator(LogIn logInDTO, String operatorKey) throws LogInException;

	public Issue addCustomerIssue(Integer customerId, Issue issue) throws CustomerNotFoundException, CallNotFoundException;
	
	public String sendIntimationEmailToCustomer(Integer customerId) throws CustomerNotFoundException;
	
	public Issue modifyCustomerIssue(Issue issue) throws IssueNotFoundException;
	
	public String sendModificationEmailToCustomer(Integer customerId) throws CustomerNotFoundException;
	
	public Issue closeCustomerIssue(Issue issue) throws IssueNotFoundException;
	
	public Customer findCustomerById(Integer customerId) throws CustomerNotFoundException;
	
	public List<Customer> findCustomerByName(String customerName) throws CustomerNotFoundException;
	
	public Customer findCustomerByEmail(String email) throws CustomerNotFoundException;
	
	public boolean lockCustomerWithOperator(Integer customerId, String opoeratorKey) throws CustomerNotFoundException;
	
}
