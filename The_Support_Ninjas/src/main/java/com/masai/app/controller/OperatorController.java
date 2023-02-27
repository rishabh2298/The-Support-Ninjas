package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.Customer;
import com.masai.app.model.Issue;
import com.masai.app.model.LogIn;
import com.masai.app.service.OperatorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/operator")
public class OperatorController {

	
	@Autowired
	private OperatorService operatorService;
	
	
	
	
	
	
	@PostMapping("/logIn")
	public ResponseEntity<String> logInOperatorHandler(@Valid @RequestBody LogIn logInDTO){
		
		String result = operatorService.logInOperator(logInDTO);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("/logOut/{operatorKey}")
	public ResponseEntity<String> logOutOperatorHandler(@PathVariable("operatorKey") String operatorKey, @Valid @RequestBody LogIn logInDTO){
		
		String result = operatorService.logOutOperator(logInDTO, operatorKey);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	


	@PostMapping("/addCustomerIssue/{customerId}")
	public ResponseEntity<Issue> addCustomerIssueHandler(@PathVariable("customerId") Integer customerId, @Valid @RequestBody Issue issue){

		Issue addedIssue = operatorService.addCustomerIssue(customerId, issue);
		
		return new ResponseEntity<>(addedIssue, HttpStatus.ACCEPTED);
		
	}
	
	

	@GetMapping("/sendIntimationEmail/{customerId}")
	public ResponseEntity<String> sendIntimationEmailToCustomerHandler(@PathVariable("customerId") Integer customerId){
		
		String result = operatorService.sendIntimationEmailToCustomer(customerId);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	
	@PutMapping("/modifyIssue/")
	public ResponseEntity<Issue> modifyCustomerIssueHandler(@Valid @RequestBody Issue issue){
		
		Issue modifiedIssue = operatorService.modifyCustomerIssue(issue);
		
		return new ResponseEntity<>(modifiedIssue, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@GetMapping("/sendModificationEmail/{customerId}")
	public ResponseEntity<String> sendModificationEmailToCustomerHandler(@PathVariable("customerId") Integer customerId){
		
		String result = operatorService.sendModificationEmailToCustomer(customerId);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	

	@DeleteMapping("/closeIssue")
	public ResponseEntity<Issue> closeCustomerIssueHandler(@Valid @RequestBody Issue issue){
		
		Issue closedIssue = operatorService.closeCustomerIssue(issue);
		
		return new ResponseEntity<>(closedIssue, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/findById/{customerId}")
	public ResponseEntity<Customer> findCustomerByIdHandler(@PathVariable("customerId") Integer customerId){
		
		Customer customer = operatorService.findCustomerById(customerId);
		
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
		
	}
	

	
	@GetMapping("/findByName/{customerName}")
	public ResponseEntity<List<Customer>> findCustomerByNameHandler(@PathVariable("customerName") String customerName){
		
		List<Customer> customers = operatorService.findCustomerByName(customerName);
		
		return new ResponseEntity<>(customers, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/findByEmail/{customerEmail}")
	public ResponseEntity<Customer> findCustomerByEmailHandler(@PathVariable("customerEmail") String customerEmail){
		
		Customer customer = operatorService.findCustomerByEmail(customerEmail);
		
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@GetMapping("/checkCustomerOperator/{customerId}/{operatorKey}")
	public ResponseEntity<Boolean> lockCustomerWithOperatorHandler(@PathVariable("customerId") Integer customerId, @PathVariable("operatorKey") String operatorKey){
		
		Boolean status = operatorService.lockCustomerWithOperator(customerId, operatorKey);
		
		return new ResponseEntity<>(status, HttpStatus.OK);
		
	}
	
	
	
	
}
