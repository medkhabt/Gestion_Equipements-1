package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	@Id
	private int id;
	private String etat;					// private String status 	01/05/2020 Med Khalil
	private String commentaire;
	@OneToOne(mappedBy = "reservation")
	private Autorisation autorisation;
	@ManyToOne
	@JoinColumn(name = "idGestionnaire")
	private Gestionnaire gestionnaire;
	
	@ManyToOne 
	@JoinColumn(name = "idEquipement")
	private Equipement equipement;
	@ManyToOne
	@JoinColumn(name = "idDemande")
	private Demande demande;
	

	public Reservation() {
		super();
	}
	public Reservation(int id, String etat, String commentaire, Autorisation autorisation, Gestionnaire gestionnaire,
			Equipement equipement, Demande demande) {
		super();
		this.id = id;
		this.etat = etat;
		this.commentaire = commentaire;
		this.autorisation = autorisation;
		this.gestionnaire = gestionnaire;
		this.equipement = equipement;
		this.demande = demande;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Autorisation getAutorisation() {
		return autorisation;
	}

	public void setAutorisation(Autorisation autorisation) {
		this.autorisation = autorisation;
	}	
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	

}
