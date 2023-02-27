package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.app.model.Department;

public interface  DepartmentRepository extends JpaRepository<Department , Integer> {
//	@Query(value = "from Department dept where dept.departmentID=?1")
//	public Department getDeptById(int code);
	
	@Query("from Department dept where dept.departmentName=?1")
	public Department checkDept(String name);
}
