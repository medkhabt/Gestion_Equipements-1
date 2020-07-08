package com.ensa.entities;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Decideur extends Utilisateur{

	public Decideur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Decideur(Long id, String username, String password, boolean actived, String nom, String prenom, String email,
			String telephone, List<GRole> roles) {
		super(id, username, password, actived, nom, prenom, email, telephone, roles);
		// TODO Auto-generated constructor stub
	}

	public Decideur(String username, String password, List<GRole> roles) {
		super(username, password, roles);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
