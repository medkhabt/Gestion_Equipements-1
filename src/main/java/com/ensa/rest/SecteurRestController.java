package com.ensa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Secteur;
import com.ensa.metier.SecteurService;

@RestController
@RequestMapping("secteurs")
public class SecteurRestController {
	@Autowired
	SecteurService secteurService;
	
	@GetMapping("")
	public List<Secteur> getSecteurs() {
		return secteurService.getAll();
	}
	@PostMapping("/create_Secteur")
	public Secteur createSecteur(@RequestBody Secteur Secteur) {
		return secteurService.createSecteur(Secteur);
	}
	@PutMapping("/update_Secteur")
	public void updateSecteur(@RequestBody Secteur Secteur, @RequestBody int id) {
		 secteurService.updateSecteur(Secteur, id);
	}
	@DeleteMapping("/delete_Secteur")
	public void deleteSecteur(@RequestBody int id) {
		secteurService.delete(id);
	}
	@GetMapping("/get_equipement/{id}")
	public Secteur getSecteur(@PathVariable int id) {
		return secteurService.getSecteur(id);
	}

}
