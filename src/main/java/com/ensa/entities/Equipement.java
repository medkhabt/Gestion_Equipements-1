package com.ensa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private int idResponsable;
	private String adresse;
	@ColumnDefault("maintenu")
	private String etat;
	@Column
	private double largeur;
	@Column
	private double longueur;
	@OneToMany(mappedBy = "equipement")
	private List<Reservation> reservations;
	@ManyToOne
	private Secteur secteur;
	
	
	public Equipement(int id, String nom, int idResponsable, String adresse, String etat, double largeur,
			double longueur, List<Reservation> reservations, Secteur secteur) {
		super();
		this.id = id;
		this.nom = nom;
		this.idResponsable = idResponsable;
		this.adresse = adresse;
		this.etat = etat;
		this.largeur = largeur;
		this.longueur = longueur;
		this.reservations = reservations;
		this.secteur = secteur;
	}
	public Equipement() {
		
	}
	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	@JsonIgnore
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> resrvations) {
		this.reservations = resrvations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public double getLargeur() {
		return largeur;
	}
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	public double getLongueur() {
		return longueur;
	}
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	

}
