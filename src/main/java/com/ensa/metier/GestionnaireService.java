package com.ensa.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Gestionnaire;
import com.ensa.repo.GestionnaireRepository;

@Service
public class GestionnaireService {
	@Autowired
	GestionnaireRepository gestionnaireRepo;
	
	public Gestionnaire createGestionnaire(Gestionnaire gestionnaire) {
		return gestionnaireRepo.save(gestionnaire);
	}
	public Gestionnaire updateGestionnaire(Gestionnaire gestionnaire, String username) {
		gestionnaire.setUsername(username);
		return gestionnaireRepo.save(gestionnaire);
	}
	public List<Gestionnaire> getAll(){
		return gestionnaireRepo.findAll();
	}
	public void delete(Gestionnaire gestionnaire) {
		gestionnaireRepo.delete(gestionnaire);
	}
	


}
