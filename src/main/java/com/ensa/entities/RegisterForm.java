package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegisterForm {
	@Id
	private String username;
	private String password;
	private String repassword;
	public RegisterForm(String username, String password, String repassword) {
		super();
		this.username = username;
		this.password = password;
		this.repassword = repassword;
	}
	public RegisterForm() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	

}
