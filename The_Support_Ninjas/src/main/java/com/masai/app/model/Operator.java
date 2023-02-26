package com.masai.app.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer operatorId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private String city;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "operator")
	private List<Call> calls = new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "operator")
	private List<Solution> solutions = new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
}
