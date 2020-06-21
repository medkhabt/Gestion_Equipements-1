package com.ensa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Demande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String reference;
	private String typeEvent;
	private Date dateDemande;
	private Date dateReservation;
	private String objet;
	private String description;
	private String nombrePresent;
	private byte[] obligationScanne;
	@ManyToOne(fetch = FetchType.LAZY)
	private Demandeur demandeur;
	@OneToMany(mappedBy = "demande")
	private List<Reservation> reservations;
	
	
	
	public Demande(int id, String reference, String typeEvent, Date dateDemande, Date dateReservation, String objet,
			String description, String nombrePresent, byte[] obligationScanne,
			Demandeur demandeur, List<Reservation> reservations) {
		this.id = id;
		this.reference = reference;
		this.typeEvent = typeEvent;
		this.dateDemande = dateDemande;
		this.dateReservation = dateReservation;
		this.obligationScanne = obligationScanne;
		this.demandeur = demandeur;
	}

	public Demande() {
	}
	public Demande(Demande demande) {
		this.id = demande.getId();
		this.reference = demande.getReference();
		this.typeEvent = demande.getTypeEvent();
		this.dateDemande = demande.getDateDemande();
		this.dateReservation = demande.getDateReservation();
		this.obligationScanne = demande.getObligationScanne();
		this.demandeur = demande.getDemandeur();
	}
	@JsonIgnore
	public Demandeur getDemandeur() {
		return demandeur;
	}
	@JsonSetter
	public void setDemandeur(Demandeur demandeur) {
		this.demandeur = demandeur;
	}
	@JsonIgnore
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getTypeEvent() {
		return typeEvent;
	}
	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}
	public Date getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNombrePresent() {
		return nombrePresent;
	}
	public void setNombrePresent(String nombrePresent) {
		this.nombrePresent = nombrePresent;
	}

	public byte[] getObligationScanne() {
		return obligationScanne;
	}

	public void setObligationScanne(byte[] obligationScanne) {
		this.obligationScanne = obligationScanne;
	}
	
	
	
	

}
