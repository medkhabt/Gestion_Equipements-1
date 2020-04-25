package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Taxe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private double valeur;
	@OneToOne(mappedBy = "taxe")
	private Autorisation autorisation;
	
	
	public Autorisation getAutorisation() {
		return autorisation;
	}
	public void setAutorisation(Autorisation autorisation) {
		this.autorisation = autorisation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	

}
