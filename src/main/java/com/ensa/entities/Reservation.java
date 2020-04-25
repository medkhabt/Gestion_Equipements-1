package com.ensa.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	@EmbeddedId
	private Reservation_PK reservation_pk;
	private String commentaire;
	@OneToOne
	@JoinColumn(name = "idAutorisation")
	private Autorisation autorisation;
	@OneToOne
	@JoinColumn(name = "idGestionnaire")
	private Gestionnaire gestionnaire;
	

	public Autorisation getAutorisation() {
		return autorisation;
	}

	public void setAutorisation(Autorisation autorisation) {
		this.autorisation = autorisation;
	}

	public Reservation() {};
	
	public Reservation(Demande demande, Equipement equipement, String comment) {
		this.reservation_pk.setEquipement(equipement);
		this.reservation_pk.setDemande(demande);
		this.commentaire = comment;
	}
	public Demande getDemande() {
		return this.reservation_pk.getDemande();
	}
	public void setDemande(Demande demande) {
		this.reservation_pk.setDemande(demande);
	}
	public Equipement getEquipement() {
		return this.reservation_pk.getEquipement();
	}
	public void setEquipement(Equipement equipement) {
		this.reservation_pk.setEquipement(equipement);
	}
	

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Reservation_PK getReservation_pk() {
		return reservation_pk;
	}

	public void setReservation_pk(Reservation_PK reservation_pk) {
		this.reservation_pk = reservation_pk;
	}
	

}
