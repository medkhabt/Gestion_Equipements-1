package com.ensa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Secteur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private double surface;
	private String responsable;
	@OneToMany(mappedBy = "secteur")
	private List<Equipement> equipements;
	@OneToOne
	@JoinColumn(name = "idQaid")
	private Qaid qaid;
	@ManyToOne
	private District district;
	
	
	public Secteur(int id, String libelle, double surface, String responsable, List<Equipement> equipements, Qaid qaid,
			District district) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.surface = surface;
		this.responsable = responsable;
		this.equipements = equipements;
		this.qaid = qaid;
		this.district = district;
	}
	
	public Secteur() {
		super();
	}

	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public Qaid getQaid() {
		return qaid;
	}
	public void setQaid(Qaid qaid) {
		this.qaid = qaid;
	}
	@JsonIgnore
	public List<Equipement> getEquipements() {
		return equipements;
	}
	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
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
