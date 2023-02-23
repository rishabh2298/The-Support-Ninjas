package com.masai.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer issueId;
	
	@Enumerated(EnumType.STRING)
	private IssueType issueType;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;
	
}
