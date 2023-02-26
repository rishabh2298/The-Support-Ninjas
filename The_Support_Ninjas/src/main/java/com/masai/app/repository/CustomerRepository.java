package com.masai.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Call;
import com.masai.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	public List<Customer> findByFirstName(String firstName);
	
	public Customer findByEmail(String email);
	
	@Query("select c.calls from Customer c where c.customerId = :id")
	public List<Call> getAllCallByCustomerId(@Param("id") Integer customerId);
	
}
