package com.ensa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class District {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private double surface;
	private String responsable;
	@OneToMany(mappedBy = "district")
	private List<Secteur> secteurs;
	@OneToOne
	@JoinColumn(name = "idBacha")
	private Bacha bacha;
	
	
	public List<Secteur> getSecteurs() {
		return secteurs;
	}
	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}
	public Bacha getBacha() {
		return bacha;
	}
	public void setBacha(Bacha bacha) {
		this.bacha = bacha;
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
	public double getSurface() {
		return surface;
	}
	public void setSurface(double surface) {
		this.surface = surface;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	

}
