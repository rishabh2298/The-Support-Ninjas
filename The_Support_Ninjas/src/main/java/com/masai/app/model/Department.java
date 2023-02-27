package com.masai.app.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentId;

	@NotNull(message = "Can't enter null value")
	@NotBlank(message = "Can't enter blank value")
	@NotEmpty(message = "Can't enter empty value")
	private String departmentName;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private List<Operator> operators = new ArrayList<>();

}
