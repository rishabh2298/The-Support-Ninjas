package com.masai.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.app.model.Call;
import com.masai.app.model.Customer;

public interface CallRepository extends JpaRepository<Call, Integer> {

	public Call findByCustomer(Customer customer);
	
	@Query("from Call c where c.issue.issueId = ?1")
	public List<Call> findByIssueId(Integer issueId);

}
