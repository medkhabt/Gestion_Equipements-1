package com.ensa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Gestionnaire extends Utilisateur {
	

	@OneToMany(mappedBy = "gestionnaire")
	private List<Reservation> reservations;
	
	public Gestionnaire(Long id, String username, String password, boolean actived, String nom, String prenom,
			String email, String telephone,List<GRole> roles) {
		super(id, username, password, actived, nom, prenom, email, telephone, roles);

	}
	public Gestionnaire() {
		super();
	}
	
	public Gestionnaire(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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

	
	
	

}
