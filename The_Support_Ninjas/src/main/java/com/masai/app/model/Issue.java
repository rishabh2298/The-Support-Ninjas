package com.masai.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer issueId;
	
//	@Enumerated(EnumType.STRING)
	private IssueType issueType;

	@NotNull(message = "Can't enter null value")
	@NotBlank(message = "Can't enter blank value")
	@NotEmpty(message = "Can't enter empty value")
	@Size(min = 10, message = "min description should be 10 characters")
	private String description;
	
//	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;
	
}
