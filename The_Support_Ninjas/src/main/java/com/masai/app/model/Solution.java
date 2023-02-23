package com.masai.app.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "issue_id")
	private Issue issue;
	
	
	@ManyToOne
	@JoinColumn(name = "operator_id")
	private Operator operator;
	
}
