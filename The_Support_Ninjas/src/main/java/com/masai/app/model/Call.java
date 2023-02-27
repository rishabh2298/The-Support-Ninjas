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
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
@Table(name = "call_details")
public class Call {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer callId;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate callDate;

	@NotNull(message = "Can't enter null value")
	private Double callDuration;

	@NotNull(message = "Can't enter null value")
	@NotBlank(message = "Can't enter blank value")
	@NotEmpty(message = "Can't enter empty value")
	private String phoneNumber;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	@Valid
	private Customer customer;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "operator_id")
	@Valid
	private Operator operator;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "issue_id")
	@Valid
	private Issue issue;
	
}
