package com.masai.app.service;

import java.util.List;

import com.masai.app.exception.CustomerNotFoundException;
import com.masai.app.exception.IssueNotFoundException;
import com.masai.app.exception.LogInException;
import com.masai.app.model.Customer;
import com.masai.app.model.Issue;
import com.masai.app.model.LogIn;

public interface CustomerService {
	
	public String logInCustomer(LogIn logInDTO) throws LogInException;
	
	public Customer registerCustomer(Customer customer) throws CustomerNotFoundException;
	
	public Issue viewIssueById(Integer issueId) throws IssueNotFoundException;
	
	public Issue reopenIssue(Integer issueId) throws IssueNotFoundException;
	
	public List<Issue> viewAllIssue(Integer customerId) throws IssueNotFoundException;

	public String changePassword(LogIn loginDTO, String otp) throws CustomerNotFoundException;
	
	public String forgotPassword(Integer customerId) throws CustomerNotFoundException;
	
}
