package com.masai.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.CustomerNotFoundException;
import com.masai.app.exception.IssueNotFoundException;
import com.masai.app.exception.LogInException;
import com.masai.app.model.Call;
import com.masai.app.model.Customer;
import com.masai.app.model.Issue;
import com.masai.app.model.IssueStatus;
import com.masai.app.model.LogIn;
import com.masai.app.repository.CustomerRepository;
import com.masai.app.repository.IssueRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LogInService logInService;
	
	@Autowired
	private IssueRepository issueRepository;
	
	private static String savedOtp = "000000";
	
	
	
	
	
	
	
	
	
	@Override
	public String logInCustomer(LogIn logInDTO) throws LogInException {
		
		return logInService.userLogIn(logInDTO);
	}
	
	

	@Override
	public String logOutCustomer(LogIn logInDTO, String operatorKey) throws LogInException {
		
		return logInService.userLogOut(logInDTO, operatorKey);
	}


	@Override
	public Customer registerCustomer(Customer customer) throws CustomerNotFoundException {
		
		Customer existedCustomer = customerRepository.findByEmail(customer.getEmail());
		
		if(existedCustomer!=null) {

			throw new CustomerNotFoundException("This customer with id="+customer.getCustomerId()+" is already exist...");		
		}

		Customer savedCustomer = customerRepository.save(customer);
		
		return savedCustomer;
	}
	

	@Override
	public Issue viewIssueById(Integer issueId) throws IssueNotFoundException {
		
		return issueRepository.findById(issueId).orElseThrow(() -> new IssueNotFoundException("Issue with id="+issueId+" does not exist..."));
		
	}

	
	@Override
	public Issue reopenIssue(Integer issueId) throws IssueNotFoundException {

		Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IssueNotFoundException("Issue with this id="+issueId+" does not exsit..."));
		
		if(issue.getIssueStatus().toString().equals("NOT_RESOLVED")) throw new IssueNotFoundException("This issue is already no resolved yet...");

		
		issue.setIssueStatus(IssueStatus.valueOf("NOT_RESOLVED"));
		
		return issueRepository.save(issue);
		
	}
	

	@Override
	public List<Issue> viewAllIssue(Integer customerId) throws IssueNotFoundException {

		List<Call> calls = customerRepository.getAllCallByCustomerId(customerId);
		
		List<Issue> issues = new ArrayList<>();
		
		calls.forEach(call -> {
			issues.add(call.getIssue());
		});
		
		return issues;
	}

	
	@Override
	public String changePassword(LogIn loginDTO, String otp) throws CustomerNotFoundException {
		
		if(!otp.equals(savedOtp)) throw new CustomerNotFoundException("You entered wrong otp");
		
		Customer customer = customerRepository.findByEmail(loginDTO.getUserName());
		
		customer.setPassword(loginDTO.getPassword());
		
		customerRepository.save(customer);
		
		return "Password changed successfully....";
	}

	
	@Override
	public String forgotPassword(Integer customerId) throws CustomerNotFoundException {
		
		customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer with id="+customerId+" does not exist..."));
		
		// generate OTP
		String numericValue = "0123456789";
		
		StringBuilder otp = new StringBuilder();
		
		for(int i=0; i<6; i++) {
			int index = (int)(numericValue.length() * Math.random());
			otp.append(numericValue.charAt(index));
		}
		
		savedOtp = otp.toString();
		
		return "Please change your password with OTP="+otp;
	}


}
