package com.ensa.security.model;

public class AuthentificationResponse {
	
	private String jwt;
	
	
	public AuthentificationResponse() {
		super();
	}
	public AuthentificationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}


	public String getJwt() {
		return jwt;
	}


}
