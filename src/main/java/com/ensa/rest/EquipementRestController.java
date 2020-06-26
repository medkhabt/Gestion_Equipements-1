package com.ensa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Bacha;
import com.ensa.entities.District;
import com.ensa.entities.Equipement;
import com.ensa.entities.Secteur;
import com.ensa.metier.EquipementService;
import com.ensa.metier.SecteurService;

@RestController
@RequestMapping("equipements")
@Transactional
public class EquipementRestController {
	@Autowired
	EquipementService equipementService;

	
	@GetMapping("")
	public List<Equipement> getEquipements() {
		return equipementService.getAll();
	}
	@PostMapping("/add")
	public Equipement createEquipement(@RequestBody Equipement equipement) {
		return equipementService.createEquipement(equipement);
	}
	@PutMapping("/update/{id}")
	public Equipement updateEquipement(@RequestBody Equipement equipement, @PathVariable int id) {
		System.out.println("secteur : "+equipement.getSecteur());
		return equipementService.updateEquipement(equipement, id);
	}
	@DeleteMapping("/delete_Equipement")
	public void deleteEquipement(@RequestBody int id) {
		equipementService.delete(id);
	}
	@GetMapping("/get_id/{id}")
	public Equipement getEquipement(@PathVariable int id) {
		return equipementService.getEquipement(id);
	}
	@GetMapping("/get_by_responsable/{idRespo}")
	public Equipement getEquipementByresponsable(@PathVariable int idrespo) {
		return equipementService.getEquipementByRespo(idrespo);
	}
	@GetMapping("/by_secteur")
	public  List<Equipement> getEquipements(@RequestBody Secteur secteur) {
		return equipementService.getEquipements(secteur);
	}
	@GetMapping("/by_district")
	public  List<Equipement> getEquipements(@RequestBody District district) {
		return equipementService.getEquipements(district);
	}
	@GetMapping("/managedByBach")
	public  List<Equipement> getEquipements(@RequestBody Bacha bacha) {
		return equipementService.getEquipements(bacha);
	}
	@GetMapping("/delete_Equipement/{id}")
	public void delete(@PathVariable int id) {
		equipementService.delete(id);
	}
	
	
	
	

	
	

}
