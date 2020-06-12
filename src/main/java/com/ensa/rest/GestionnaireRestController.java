package com.ensa.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.GRole;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.RegisterForm;
import com.ensa.metier.GestionnaireService;;


@RestController
@RequestMapping("gestionnaires/")

public class GestionnaireRestController {
	@Autowired
	GestionnaireService gestionnaireService;

	
	@GetMapping("")
	public List<Gestionnaire> getGestioannaires(){
		return gestionnaireService.getAll();
	}
	@PostMapping("/register")
	public Gestionnaire createGestionnaire(@RequestBody Gestionnaire gestionnaire) {
//		if(!gestionnaireForm.getPassword().equals(gestionnaireForm.getRepassword())) throw
//		new RuntimeCryptoException("You must confirm your password");
		Gestionnaire gestTest = gestionnaireService.findByUsername(gestionnaire.getUsername());
		if(gestTest!=null) throw new RuntimeCryptoException("this user alreeady exists !");
		gestionnaireService.saveGestionnaire(gestionnaire);
		gestionnaireService.addRoleToGestionnaire(gestionnaire.getUsername(), "Admin");
		return gestionnaire;

	}
	@GetMapping("{username}")
	public Gestionnaire getByUsername(@PathVariable String username) {
		return gestionnaireService.findByUsername(username);
	}
//	@GetMapping("{id}")
//	public Gestionnaire getById(@PathVariable long id) {
//		return gestionnaireService.findById(id);
//	}
	@PutMapping("/update_gestionnaire")
	public void updateGestionnaire(@RequestBody Gestionnaire gestionnaire, @PathVariable Long id) {
		gestionnaireService.updateGestionnaire(gestionnaire, id);
	}
	@DeleteMapping("/delete")
	public void deleteGestionnaire(@RequestBody Gestionnaire gestionnaire) {
		gestionnaireService.delete(gestionnaire);
	}
	
	
	
	
	
	
	
	

}
