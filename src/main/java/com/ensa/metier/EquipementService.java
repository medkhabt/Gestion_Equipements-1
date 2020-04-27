package com.ensa.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Bacha;
import com.ensa.entities.District;
import com.ensa.entities.Equipement;
import com.ensa.entities.Secteur;
import com.ensa.repo.EquipementRepository;

@Service
public class EquipementService {
	@Autowired
	EquipementRepository equipementRepo;
	
	public List<Equipement> getAll(){
		return equipementRepo.findAll();
	}
	public Equipement getEquipement(int id) {
		return equipementRepo.findById(id);
	}
	public Equipement createEquipement(Equipement equipement) {
		return equipementRepo.save(equipement);
	}
	public Equipement updateEquipement(Equipement equipement, int id) {
		equipement.setId(id);
		return equipementRepo.save(equipement);
	}
	public Equipement getEquipementByRespo(int idrespo) {
		return equipementRepo.findByIdResponsable(idrespo);
	}
	public Equipement getEquipement(String nom) {
		return equipementRepo.findByNom(nom);
	}
	public List<Equipement> getEquipements(Secteur secteur){
		return equipementRepo.findBySecteur(secteur);
	}
	public Equipement getByLocalization(double largeur, double longueur) {
		return equipementRepo.findByLargeurAndLongueur(largeur, longueur);
	}
	public void delete(int id) {
		equipementRepo.deleteById(id);
	}
	public void delete(Equipement equipement) {
		equipementRepo.delete(equipement);
	}
	
	
	/*interaction*/
	
//	public District getDistrict(Equipement equipement) {
//		return equipement.getSecteur().getDistrict();
//	}
	public List<Equipement> getEquipements(District district){
		List<Secteur> secteurs = district.getSecteurs()  ;
		List<Equipement> equipements = new ArrayList<>();
		
		for(Secteur secteur : secteurs) {
			equipements.addAll(secteur.getEquipements());
		}
		return equipements;
	}
	public List<Equipement> getEquipements(Bacha bacha){
		return this.getEquipements(bacha.getDistrict());
	}
	

}
