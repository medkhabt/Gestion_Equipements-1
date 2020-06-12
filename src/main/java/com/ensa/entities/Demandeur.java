package com.ensa.entities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Demandeur extends Utilisateur {
	
	private String type;
	private String adresse;
	@Column(name ="recepisse", length = 900000 )
	private byte[] recepisse;
	@Column(name ="statut", length = 500000 )
	private byte[] statut;
	@Column(name ="imageProfile", length = 900000 )
	private byte[] imageProfile;
	@OneToMany(mappedBy = "demandeur", fetch = FetchType.LAZY)
	private List<Demande> demandes;
	
	public Demandeur() {
		super();
	}
	public Demandeur(String username, String password, List<GRole> roles) {
		super(username, password, roles);
	}
	
	public Demandeur(Demandeur demandeur) {
		super(demandeur.getId(), demandeur.getUsername(), demandeur.getPassword(), demandeur.isActived(), demandeur.getNom(), demandeur.getPrenom(), demandeur.getEmail(), demandeur.getTelephone(), demandeur.getRoles());
		this.type = demandeur.getType();
		this.adresse = demandeur.getAdresse();
		this.recepisse = demandeur.getRecepisse();
		this.statut = demandeur.getStatut();
		this.imageProfile = demandeur.getImageProfile();
		this.demandes = demandeur.getDemandes();
	}
	
	public Demandeur(Long id, String username, String password, boolean actived, String nom, String prenom,
			String email, String telephone, List<GRole> roles, String type, String adresse, byte[] recepisse,
			byte[] statut, byte[] imageProfile, List<Demande> demandes) {
		super(id, username, password, actived, nom, prenom, email, telephone, roles);
		this.type = type;
		this.adresse = adresse;
		this.recepisse = recepisse;
		this.statut = statut;
		this.imageProfile = imageProfile;
		this.demandes = demandes;
	}
	public List<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public byte[] getRecepisse() {
		return recepisse;
	}
	public void setRecepisse(byte[] recepisse) {
		this.recepisse = recepisse;
	}
	public byte[] getStatut() {
		return statut;
	}
	public void setStatut(byte[] statut) {
		this.statut = statut;
	}
	public byte[] getImageProfile() {
		return imageProfile;
	}
	public void setImageProfile(byte[] imageProfile) {
		this.imageProfile = imageProfile;
	}
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	
	
	
	

}
