package com.ensa.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Reservation_PK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "IdEquipement")
	private Equipement equipement;
	@ManyToOne
	@JoinColumn(name = "IdDemande")
	private Demande demande;
	
	
	
	public Reservation_PK() {
	}
	public Reservation_PK(Equipement equipement, Demande demande) {
		this.equipement = equipement;
		this.demande = demande;
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
	
	



}
