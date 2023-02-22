package com.masai.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String mobile;
	private String city;
	
}
