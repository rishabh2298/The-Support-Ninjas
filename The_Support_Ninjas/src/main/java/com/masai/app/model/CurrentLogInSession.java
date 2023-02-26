package com.masai.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentLogInSession {
	
	@Id
	@Column(unique = true)
	private String userName;
	private String uuid;
	private String password;
	
}
