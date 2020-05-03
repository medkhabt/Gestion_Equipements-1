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

import com.ensa.entities.Gestionnaire;
import com.ensa.metier.GestionnaireService;

@RestController
@RequestMapping("gestionnaires")
public class GestionnaireRestController {
	@Autowired
	GestionnaireService gestionnaireService;
	
	@GetMapping("")
	public List<Gestionnaire> getGestioannaires(){
		return gestionnaireService.getAll();
	}
	@PostMapping("/create_gestionnaire")
	public void createGestionnaire(@RequestBody Gestionnaire gestionnaire) {
		gestionnaireService.createGestionnaire(gestionnaire);
	}
	@PutMapping("/update_gestionnaire")
	public void updateGestionnaire(@RequestBody Gestionnaire gestionnaire, @PathVariable String username) {
		gestionnaireService.updateGestionnaire(gestionnaire, username);
	}
	@DeleteMapping("/delete")
	public void deleteGestionnaire(@RequestBody Gestionnaire gestionnaire) {
		gestionnaireService.delete(gestionnaire);
	}
	
	
	
	
	
	
	
	

}
