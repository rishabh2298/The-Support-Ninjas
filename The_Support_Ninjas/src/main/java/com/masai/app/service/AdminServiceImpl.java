package com.masai.app.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.masai.app.exception.DepartmentNotFoundException;
import com.masai.app.exception.OperatorNotFoundException;
import com.masai.app.model.Department;
import com.masai.app.model.Operator;
import com.masai.app.repository.DepartmentRepository;
import com.masai.app.repository.OperatorRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	OperatorRepository operatorRepository;

	@Override
	public boolean addDepartment(Department department) throws DepartmentNotFoundException {
		departmentRepository.save(department);
		return true;
	}

	@Override
	public boolean removeDepartment(Integer departmentId) throws DepartmentNotFoundException {

		departmentRepository.deleteById(departmentId);
		return true;
	}

	@Override
	public Department modifyDepartment(Department department) throws DepartmentNotFoundException {
		int id = department.getDepartmentId();
		Department department1 = departmentRepository.findById(id).get();
		department1.setDepartmentName(department1.getDepartmentName());

		departmentRepository.save(department1);
		return department1;
	}

	@Override
	public Department findDepartmentById(int id) throws DepartmentNotFoundException {

		return departmentRepository.findById(id).get();
	}

	@Override
	public boolean addOperator(Integer departmentID, Operator operator) throws OperatorNotFoundException {
		departmentRepository.findById(departmentID)
				.orElseThrow(() -> new DepartmentNotFoundException("depoartment not found."));
		operatorRepository.save(operator);
		return true;
	}

	@Override
	public boolean removeOperator(Integer operatorId) throws OperatorNotFoundException {
		operatorRepository.deleteById(operatorId);
		return true;
	}

	@Override
	public Operator modifyOperator(Operator operator) throws OperatorNotFoundException {
		// TODO Auto-generated method stub
		int id = operator.getOperatorId();
		Operator oper = operatorRepository.findById(id).get();
		oper.setFirstName(operator.getFirstName());
		oper.setLastName(operator.getLastName());
		oper.setMobile(operator.getMobile());
		oper.setEmail(operator.getEmail());
		oper.setCity(operator.getCity());
		operatorRepository.save(oper);
		return oper;
	}

	@Override
	public Operator findOperatorbyId(Integer operatorId) throws OperatorNotFoundException {
		return operatorRepository.findById(operatorId)
				.orElseThrow(() -> new OperatorNotFoundException("Operator not found..."));

	}

	@Override
	public List<Operator> findAllOperator() throws OperatorNotFoundException {
		List<Operator> operators = operatorRepository.findAll();
		return operators;

	}

}
