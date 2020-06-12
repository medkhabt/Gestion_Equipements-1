package com.ensa.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Autorisation;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.metier.AutorisationService;

@RestController
@RequestMapping("/autorisations")
@EnableWebSecurity
//@CrossOrigin(origins = "*")
public class AutorisationRestController {
	@Autowired
	AutorisationService autorisationService;
	
	@GetMapping("/test")
	public String hello() {
		return "authentification avec succés";
	}
//	@Secured({"ROLE_ADMIN","ROLE_DEMANDEUR"} )
	@GetMapping("")
	public List<Autorisation> getAutorisations(){
		return autorisationService.getAll();
	}
//	@Secured({"ROLE_ADMIN"})
	@GetMapping("/get/{id}")
	public Autorisation getAutorisation(@PathVariable int id) {
		 return autorisationService.getAutosiation(id);
	}
	@PostMapping("/add")
	public void creatAutorisation(@RequestBody Autorisation autorisation) {
		 autorisationService.createAutorisation(autorisation);
	}
	@PutMapping("/update_autorisation/{id}")
	public void updateAutorisation(@RequestBody Autorisation autorisation, @PathVariable int id) {
		autorisationService.updateAutorisation(autorisation, id);
	}
	@DeleteMapping("/delete_autorisation/{id}")
	public void deleteAutorisation(@PathVariable int id) {
		autorisationService.deleteAutorisation(id);
	}
	@GetMapping("/date_reservation")
	public  List<Autorisation> getAutorisation(@RequestBody Date dateReservation) {
		return autorisationService.getAutorisation(dateReservation);
	}
	@GetMapping("/{type}")
	public List<Autorisation> getAutorisation(@PathVariable String type) {
		return autorisationService.getAutorisation(type);
	}
	@GetMapping("/par_equipement")
	public List<Autorisation> getAutorisations(@RequestBody Equipement equipement){
		return autorisationService.getAutorisations(equipement);
	}
	@GetMapping("/par_demandeur")
	public List<Autorisation> getAutorisations(@RequestBody Demandeur demandeur) {
		return autorisationService.getAutorisations(demandeur);
	}
	@GetMapping("/par_gestionnaire")
	public List<Autorisation> getAutorisations(@RequestBody Gestionnaire gestionnaire) {
		return autorisationService.getAutorisations(gestionnaire);
	}
	
	
	

	
	
	
	
}
