package com.ensa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
	private Date dateDebutReservation;
	private Date dateFinReservation;
	private String objet;
	private String description;
	private String nombrePresent;
	@Column(name ="obligationScanne", length = 900000 )
	private byte[] obligationScanne;
	@ManyToOne(fetch = FetchType.LAZY)
	private Demandeur demandeur;
	@OneToMany(mappedBy = "demande")
	private List<Reservation> reservations;
	

	public Demande() {
	}
	public Demande(Demande demande) {
		this.id = demande.getId();
		this.reference = demande.getReference();
		this.typeEvent = demande.getTypeEvent();
		this.dateDemande = demande.getDateDemande();
		this.dateDebutReservation = demande.getDateDebutReservation();
		this.dateFinReservation = demande.getDateFinReservation();
		this.obligationScanne = demande.getObligationScanne();
		this.demandeur = demande.getDemandeur();
		this.objet = demande.getObjet();
		this.description = demande.getDescription();
		this.nombrePresent = demande.getNombrePresent();
	}
	
	public Demande(int id, String reference, String typeEvent, Date dateDemande, Date dateDebutReservation, String objet,
			String description, String nombrePresent, byte[] obligationScanne, Demandeur demandeur,
			List<Reservation> reservations, Date dateFinReservation) {
		super();
		this.id = id;
		this.reference = reference;
		this.typeEvent = typeEvent;
		this.dateDemande = dateDemande;
		this.dateDebutReservation = dateDebutReservation;
		this.dateFinReservation = dateFinReservation;
		this.objet = objet;
		this.description = description;
		this.nombrePresent = nombrePresent;
		this.obligationScanne = obligationScanne;
		this.demandeur = demandeur;
		this.reservations = reservations;
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
	public Date getDateDebutReservation() {
		return dateDebutReservation;
	}
	public void setDateDebutReservation(Date dateDebutReservation) {
		this.dateDebutReservation = dateDebutReservation;
	}
	public Date getDateFinReservation() {
		return dateFinReservation;
	}
	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
	}
	
	
	
	
	

}
