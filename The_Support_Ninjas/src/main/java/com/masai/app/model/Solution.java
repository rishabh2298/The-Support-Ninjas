package com.masai.app.model;

import java.time.LocalDate;

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
public class Solution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer solutionId;
	private String solutionDescription;
	private LocalDate solutionDate;
	
}
