package com.ensa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Demandeur extends User {
	@Id
	@Column(nullable = false)
	protected String username;
	@Column(nullable = false)
	protected String password;
	protected boolean actived;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String type;
	private String adresse;
	@OneToMany(mappedBy = "demandeur")
	private List<Demande> demandes;
	
	public Demandeur(String username, String password, String nom, String prenom, String email, String telephone,
			String type, String adresse) {
		super(username, password);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.type = type;
		this.adresse = adresse;
	}
	
	public Demandeur(String username, String password) {
		super(username, password);
	}

	public List<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	public Demandeur() {
	
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	

}
