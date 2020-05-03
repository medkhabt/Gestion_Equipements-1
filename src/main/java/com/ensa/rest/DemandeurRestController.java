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

import com.ensa.entities.Demandeur;
import com.ensa.metier.DemandeurService;

@RestController
@RequestMapping("demandeurs")
public class DemandeurRestController {
	@Autowired
	DemandeurService demandeurService;
	
	@GetMapping("")
	public List<Demandeur> getDemandeurs() {
		return demandeurService.getAll();
	}
	@PostMapping("/create_demandeur")
	public void createDemandeur(@RequestBody Demandeur demandeur) {
		 demandeurService.createDemandeur(demandeur);
	}
	@PutMapping("/update_demandeur")
	public void updateDemandeur(@RequestBody Demandeur demandeur, @RequestBody String username) {
		demandeurService.updateDemandeur(demandeur, username);
	}
	@DeleteMapping("/delete_demandeur")
	public void deleteDemandeur(@PathVariable int id) {
		demandeurService.delete(id);
	}
	@GetMapping("/{username}")
	public Demandeur getDemandeur(@PathVariable String username) {
		return demandeurService.getDemandeur(username);
	}
	@GetMapping("/nom_et_prenom/{nom}+{prenom}")
	public Demandeur getDemadeur(@PathVariable String nom, @PathVariable String prenom) {
		return demandeurService.getDemandeur(nom, prenom);
	}
	@GetMapping("/type_demandeur")
	public List<Demandeur> getDemandeurByType(@RequestBody String type) {
		return demandeurService.getDemandeurByType(type);
	}
	@GetMapping("/tel_demandeur")
	public Demandeur getDemandeurByTel(@RequestBody String tel) {
		return demandeurService.getDemandeurByTel(tel);
	}
	@GetMapping("/username")
	public Demandeur getDemandeurByUserAndPass(@RequestBody String username, @RequestBody String password){
		return demandeurService.getDemandeurByUserPass(username, password);
	}
	@GetMapping("/delete_username")
	public void delete(@RequestBody String username) {
		demandeurService.delete(username);
	}
	@GetMapping("/delete_id/{id}")
	public void delete(@PathVariable int id) {
		demandeurService.delete(id);
	}
	
	
	

}
