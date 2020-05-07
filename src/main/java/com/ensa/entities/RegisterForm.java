package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegisterForm {
	@Id
	private String username;
	private String password;
	private String repassword;
	private String nom;
	private String telephone;
	private String email;
	private String adresse;
	private String actived;
	
	
	public RegisterForm(String username, String password, String repassword, String nom, String telephone, String email,
			String adresse, String actived) {
		super();
		this.username = username;
		this.password = password;
		this.repassword = repassword;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.actived = actived;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getActived() {
		return actived;
	}
	public void setActived(String actived) {
		this.actived = actived;
	}
	
	

}
