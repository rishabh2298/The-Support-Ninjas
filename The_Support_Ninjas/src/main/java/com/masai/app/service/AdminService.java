package com.masai.app.service;

import java.util.List;

import com.masai.app.exception.DepartmentNotFoundException;
import com.masai.app.exception.OperatorNotFoundException;
import com.masai.app.model.Department;
import com.masai.app.model.Operator;

public interface AdminService {
	
	public boolean addDepartment(Department department)throws DepartmentNotFoundException;
	
	public boolean removeDepartment(Integer departmentId)throws DepartmentNotFoundException;
	
	public Department modifyDepartment(Department department)throws DepartmentNotFoundException;
	
	public Department findDepartmentById(Department department)throws DepartmentNotFoundException;

	
	public boolean addOperator(Integer departmentID,Operator operator)throws OperatorNotFoundException;
	
	public boolean removeOperator(Integer operatorId) throws OperatorNotFoundException;
	
	public Operator modifyOperator(Operator operator)throws OperatorNotFoundException;
	
	public Operator findOperatorbyId(Integer operatorId)throws OperatorNotFoundException;
	
	public List<Operator> findAllOperator() throws OperatorNotFoundException;
	
	
	
	
	
}

