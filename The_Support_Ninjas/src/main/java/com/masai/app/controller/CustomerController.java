package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.Customer;
import com.masai.app.model.Issue;
import com.masai.app.model.LogIn;
import com.masai.app.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;

	
	
	
	
	
	
	
	@PostMapping("/logIn")
	public ResponseEntity<String> logInCustomerHandler(@Valid @RequestBody LogIn logIn) {
		
		String result = customerService.logInCustomer(logIn);
		
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	

	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer) {
		
		Customer savedCustomer = customerService.registerCustomer(customer);
		
		return new ResponseEntity<>(savedCustomer, HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/viewIssue/{issueId}")
	public ResponseEntity<Issue> viewCustomerIssueByIdHandler(@PathVariable("issueId") Integer issueId) {
		
		Issue issue = customerService.viewIssueById(issueId);
		
		return new ResponseEntity<>(issue , HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/reopenIssue/{issueId}")
	public ResponseEntity<Issue> reopenCustomerIssueByIdHandler(@PathVariable("issueId") Integer issueId) {
		
		Issue issue = customerService.reopenIssue(issueId);
		
		return new ResponseEntity<>(issue , HttpStatus.OK);
	}
	
	

	@GetMapping("/viewAllIssue/{customerId}")
	public ResponseEntity<List<Issue>> viewAllIssueHandler(@PathVariable("customerId") Integer customerId) {
		
		List<Issue> issues = customerService.viewAllIssue(customerId);
		
		return new ResponseEntity<>(issues , HttpStatus.OK);
	}
	
	
	
	@PostMapping("/changePassword/{otp}")
	public ResponseEntity<String> changePasswordHandler(@PathVariable("otp") String customerOTP, @RequestBody LogIn logInDTO) {
		
		String result = customerService.changePassword(logInDTO, customerOTP);
		
		return new ResponseEntity<>(result , HttpStatus.ACCEPTED);
	}
	
	
	

	@PostMapping("/fogetPassword/{customerId}")
	public ResponseEntity<String> forgetPasswordHandler(@PathVariable("customerId") Integer customerId) {
		
		String result = customerService.forgotPassword(customerId);
		
		return new ResponseEntity<>(result , HttpStatus.OK);
	}
	
	
	
}
