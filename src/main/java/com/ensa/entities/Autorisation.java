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
	private Date dateAutorisation;
	private String type;
	private String objectif;
	private File fichierWord;
	
	@OneToOne
	@JoinColumn(name = "idReservation")
	private Reservation reservation;
	@OneToOne
	@JoinColumn(name = "idTaxe")
	private Taxe taxe;
	
	public Autorisation(int id, Date dateAutorisation, Date dateFin, String type, String objectif, File fichierWord,
			Reservation reservation, Taxe taxe) {
		super();
		this.id = id;
		this.dateAutorisation = dateAutorisation;
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

	public Date getDateAutorisation() {
		return dateAutorisation;
	}

	public void setDateAutorisation(Date dateAutorisation) {
		this.dateAutorisation = dateAutorisation;
	}
	
	
	
	
}
