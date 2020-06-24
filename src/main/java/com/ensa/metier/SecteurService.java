package com.ensa.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Secteur;
import com.ensa.repo.SecteurRepository;

@Service
public class SecteurService {
	
	@Autowired
	SecteurRepository secteurRepo;
	
	public Secteur createSecteur(Secteur secteur) {
		return secteurRepo.save(secteur);
	}
	public Secteur updateSecteur(Secteur secteur, int id) {
		secteur.setId(id);
		return secteurRepo.save(secteur);
	}
	public List<Secteur> getAll(){
		return secteurRepo.findAll();
	}
	public void delete(int id) {
		secteurRepo.deleteById(id);
	}
	public Secteur getSecteur(int id) {
		return secteurRepo.findById(id);
	}
}
