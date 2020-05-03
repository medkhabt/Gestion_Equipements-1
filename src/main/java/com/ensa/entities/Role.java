package com.ensa.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {
	@Id
	private String role;
	private String description;
	
	
	public Role() {
		super();
	}

	public Role(String role, String description) {
		this.role = role;
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
