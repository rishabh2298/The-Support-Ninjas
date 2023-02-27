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
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.exception.DepartmentNotFoundException;
import com.masai.app.exception.OperatorNotFoundException;
import com.masai.app.model.Department;
import com.masai.app.model.Operator;
import com.masai.app.service.AdminService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	
	@Autowired
	AdminService service;

	@PostMapping("/addDepartment") // adds department for whatever values given to the members
	public String addDepartment(@Valid @RequestBody Department department) {

		service.addDepartment(department);
		return "Department added";

	}

	@DeleteMapping("/deleteDepartment/{code}") // deletes the department having the given departmentID(integer given as
												// ip)
	public String deleteDepartment(@PathVariable int code) throws DepartmentNotFoundException {

		service.removeDepartment(code);
		return "Deleted";

	}

	@PostMapping("/updateDepartment") // Makes modification to department without altering primarykey and throws
										// exception if ID not found
	public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department department)
			throws DepartmentNotFoundException {

		Department depart = service.modifyDepartment(department);
		return new ResponseEntity<Department>(depart, HttpStatus.OK);

	}

	@GetMapping("/findDepartment") // Finds and shows department having given ID and throws exception if no ID
									// number is found
	public ResponseEntity<Department> findDepartment(@RequestBody int code) throws DepartmentNotFoundException {

		Department depart = service.findDepartmentById(code);
		return new ResponseEntity<Department>(depart, HttpStatus.OK);

	}

	@PostMapping("/addOperator/{deptid}") // adds department for whatever values given to the members
	public String addOperator(@Valid @RequestBody Operator operator, @PathVariable Integer deptid) {

		service.addOperator(deptid, operator);
		return "Operator added";

	}

	@DeleteMapping("/deleteOperator/{code}") // Deletes operator having given operatorID and throws exception if integer
												// passed does not match any existing Id no
	public String deleteOperator(@PathVariable int code) throws OperatorNotFoundException {

		service.removeOperator(code);
		return "Deleted";

	}

	@PutMapping("/updateOperator") // Modifies or updates for given ID number or exception otherwise
	public ResponseEntity<Operator> updateOperator(@Valid @RequestBody Operator operator)
			throws OperatorNotFoundException {

		Operator oper = service.modifyOperator(operator);
		return new ResponseEntity<Operator>(oper, HttpStatus.OK);

	}

	@GetMapping("/findOperator/{code}") // Finds and shows operator having given operatorID and throws exception
										// otherwise
	public ResponseEntity<Operator> findOperator(@PathVariable int code) throws OperatorNotFoundException {

		Operator operator = service.findOperatorbyId(code);
		return new ResponseEntity<Operator>(operator, HttpStatus.OK);

	}

	@GetMapping("/allOperators") // shows the list of operators or else gives exception if there are no operators
	public ResponseEntity<List<Operator>> findAll() throws OperatorNotFoundException {
		List<Operator> operators = service.findAllOperator();
		if (operators.size() > 0) {
			return new ResponseEntity<List<Operator>>(operators, HttpStatus.OK);
		} else {
			throw new OperatorNotFoundException();
		}
	}

}