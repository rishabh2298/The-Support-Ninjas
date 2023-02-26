package com.masai.app.service;

import java.util.List;

import com.masai.app.exception.CustomerNotFoundException;
import com.masai.app.exception.IssueNotFoundException;
import com.masai.app.model.Customer;
import com.masai.app.model.Issue;

public interface CustomerService {
	
	public String registerCustomer(Customer customer) throws CustomerNotFoundException;
	
	public Issue viewIssueById(Integer issueId) throws IssueNotFoundException;
	
	public Issue reopenIssue(Integer issueId) throws IssueNotFoundException;
	
	public List<Issue> viewAllIssue() throws IssueNotFoundException;

}
