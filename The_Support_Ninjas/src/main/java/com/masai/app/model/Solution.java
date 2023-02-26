package com.masai.app.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

	@NotNull(message = "Can't enter null value")
	@NotBlank(message = "Can't enter blank value")
	@NotEmpty(message = "Can't enter empty value")
	@Size(min = 6, max = 10 , message = "Character should be between 6 to 10")
	private String solutionDescription;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate solutionDate;
	
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "issue_id")
	@Valid
	private Issue issue;
	
	
	@ManyToOne
	@JoinColumn(name = "operator_id")
	private Operator operator;
	
}
