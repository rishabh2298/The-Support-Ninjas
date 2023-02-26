package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.CurrentLogInSession;

@Repository
public interface CurrentLogInSessionRepository extends JpaRepository<CurrentLogInSession, String> {

	public CurrentLogInSession findByUserName(String userName);
	
	public CurrentLogInSession findByUuid(String key);
	
}
