package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {

	public Operator findByEmail(String email);
	
}
