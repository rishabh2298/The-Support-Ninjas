package com.masai.app.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogIn {

	@NotNull(message = "Can't enter null value")
	@NotBlank(message = "Can't enter blank value")
	@NotEmpty(message = "Can't enter empty value")
	private String userName;

	@NotNull(message = "Can't enter null value")
	@NotBlank(message = "Can't enter blank value")
	@NotEmpty(message = "Can't enter empty value")
	@Size(min = 6, max = 10 , message = "Character should be between 6 to 10")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private LogInType userType;
	
	private Boolean isActive;

}
