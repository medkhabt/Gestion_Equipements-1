package com.ensa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private int idResponsable;
	private double adresse;
	private double largeur;
	private double longueur;
	@OneToMany(mappedBy = "equipement")
	private List<Reservation> reservations;
	@ManyToOne
	private Secteur secteur;
	
	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
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
	public double getAdresse() {
		return adresse;
	}
	public void setAdresse(double adresse) {
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
	

}
