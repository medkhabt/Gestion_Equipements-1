package com.ensa.entities;

import java.io.File;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Autorisation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date dateReservation;
	private Date dateFin;
	private String type;
	private String objectif;
	private File fichierWord;
	
	@OneToOne
	@JoinColumn(name = "idReservation")
	private Reservation reservation;
	@OneToOne
	@JoinColumn(name = "idTaxe")
	private Taxe taxe;
	
	public Autorisation(int id, Date dateReservation, Date dateFin, String type, String objectif, File fichierWord,
			Reservation reservation, Taxe taxe) {
		super();
		this.id = id;
		this.dateReservation = dateReservation;
		this.dateFin = dateFin;
		this.type = type;
		this.objectif = objectif;
		this.fichierWord = fichierWord;
		this.reservation = reservation;
		this.taxe = taxe;
	}
	
	public Autorisation() {
		super();
	}

	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	@JsonIgnore
	public Taxe getTaxe() {
		return taxe;
	}
	public void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}
	public File getFichierWord() {
		return fichierWord;
	}
	public void setFichierWord(File fichierWord) {
		this.fichierWord = fichierWord;
	}
	
	
	
}
