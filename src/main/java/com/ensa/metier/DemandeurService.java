package com.ensa.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Demandeur;
import com.ensa.repo.DemandeurRepository;

@Service
public class DemandeurService {
	@Autowired
	DemandeurRepository demandeurRepo;
	
	public List<Demandeur> getAll(){
		return demandeurRepo.findAll();
	}
	public Demandeur getDemandeur(String username) {
		return demandeurRepo.findByUsername(username);
	}
	public Demandeur getDemandeur(String nom, String prenom) {
		return demandeurRepo.findByNomAndPrenom(nom, prenom);
	}
	public Demandeur createDemandeur(Demandeur demandeur) {
		return demandeurRepo.save(demandeur);
	}
	public Demandeur updateDemandeur(Demandeur demandeur, Long id) {
		demandeur.setId(id);
		return demandeurRepo.save(demandeur);
	}
	public List<Demandeur> getDemandeurByType(String type) {
		return demandeurRepo.findByType(type);
	}
	public Demandeur getDemandeurByTel(String telephone) {
		return demandeurRepo.findByTelephone(telephone);
	}
	public Demandeur getDemandeurByUserPass(String username, String password) {
		return demandeurRepo.findByUsernameAndPassword(username, password);
	}
	public void delete(Long id) {
		demandeurRepo.deleteById(id);
	}
	public void delete(String username) {
		demandeurRepo.deleteByUsername(username);
	}

}
