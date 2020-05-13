package com.ensa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
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
//	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
//	private List<Demande> demandes;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
	private List<GRole> roles ;
//	@OneToMany(mappedBy = "utilisateur")
//	private List<Reservation> reservations;
	public Utilisateur(Long id, String username, String password, boolean actived, String nom, String prenom,
			String email, String telephone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
	}
	public Utilisateur(Long id, String username, String password, boolean actived, String nom, String prenom,
			String email, String telephone, String type, String adresse) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.type = type;
		this.adresse = adresse;
	}
	public Utilisateur(String username, String password, List<GRole> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
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
//	public List<Demande> getDemandes() {
//		return demandes;
//	}
//	public void setDemandes(List<Demande> demandes) {
//		this.demandes = demandes;
//	}
//	public List<GRole> getRoles() {
//		return roles;
//	}
//	public void setRoles(List<GRole> roles) {
//		this.roles = roles;
//	}
//	public List<Reservation> getReservations() {
//		return reservations;
//	}
//	public void setReservations(List<Reservation> reservations) {
//		this.reservations = reservations;
//	}
	
	

}
