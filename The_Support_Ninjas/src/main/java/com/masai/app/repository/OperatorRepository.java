package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.model.Operator;

public interface OperatorRepository extends JpaRepository<Operator, Integer> {

//	Operator checkoper(Integer operatorId);

}
