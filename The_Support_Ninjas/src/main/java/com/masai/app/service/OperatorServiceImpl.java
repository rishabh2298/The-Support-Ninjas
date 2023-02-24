package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.CallNotFoundException;
import com.masai.app.exception.CustomerNotFoundException;
import com.masai.app.exception.IssueNotFoundException;
import com.masai.app.model.Call;
import com.masai.app.model.Customer;
import com.masai.app.model.Issue;
import com.masai.app.model.IssueStatus;
import com.masai.app.repository.CallRepository;
import com.masai.app.repository.CustomerRepository;
import com.masai.app.repository.IssueRepository;

@Service
public class OperatorServiceImpl implements OperatorService {
	

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CallRepository callRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	
	
	

	
	
	@Override
	public Issue addCustomerIssue(Integer customerId, Issue issue) throws CustomerNotFoundException, CallNotFoundException {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("No such customer with this id="+customerId+" exit....."));

		Call call = callRepository.findByCustomer(customer);		
		if(call == null) throw new CallNotFoundException("There was no call for this issue found....");
		
		call.setIssue(issue);
		
		return issue;
	}
	
	

	@Override
	public String sendIntimationEmailToCustomer(Integer customerId) throws CustomerNotFoundException {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("No customer with this Id found...."));
		
		String email = customer.getEmail();
		
		return "To "+email+"\nThis is an Intimation Email to customer = "+customer.getFirstName()+" "+customer.getLastName()+"\n Regards Customer Service";
	}

	
	
	@Override
	public Issue modifyCustomerIssue(Issue issue) throws IssueNotFoundException {
		
		issueRepository.findById(issue.getIssueId()).orElseThrow(() -> new IssueNotFoundException("No such issue found, first create one...."));
		
		return issueRepository.save(issue);

	}

	
	
	@Override
	public String sendModificationEmailToCustomer(Integer customerId) throws CustomerNotFoundException {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("No such customer with id="+customerId+" exist...."));
		
		return "To "+customer.getEmail()+"\nThis is an Modified Email to customer = "+customer.getFirstName()+" "+customer.getLastName()+"\n Regards Customer Service";

	}

	
	
	@Override
	public Issue closeCustomerIssue(Issue issue) throws IssueNotFoundException {

		Issue existingIssue = issueRepository.findById(issue.getIssueId()).orElseThrow(() -> new IssueNotFoundException("No such issue found..."));
		
//		List<Call> calls = callRepository.findByIssueId(issue.getIssueId());
		
		issue.setIssueStatus(IssueStatus.valueOf("RESOLVED"));
		issue.setIssueType(existingIssue.getIssueType());
		
		return issueRepository.save(issue);
		
	}

	
	
	@Override
	public Customer findCustomerById(Integer customerId) throws CustomerNotFoundException {
		
		return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("No such customer found with id="+customerId));
	}

	
	
	@Override
	public List<Customer> findCustomerByName(String customerName) throws CustomerNotFoundException {
		
		List<Customer> customers = customerRepository.findByFirstName(customerName);
		
		if(customers.isEmpty()) throw new CustomerNotFoundException("No customer found with Fist Name = "+customerName);
		
		return customers;
	}

	
	
	@Override
	public Customer findCustomerByEmail(String email) throws CustomerNotFoundException {
		
		Customer customer = customerRepository.findByEmail(email);
		
		if(customer==null) throw new CustomerNotFoundException("No customer found with email="+email);
		
		return customer;
	}

	
	
	@Override
	public boolean lockCustomer(Integer customerId) throws CustomerNotFoundException {
		

		return false;
	}

	
}
