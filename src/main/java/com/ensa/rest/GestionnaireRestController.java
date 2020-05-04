package com.ensa.rest;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("")
public class GestionnaireRestController {
	@Autowired
	GestionnaireService gestionnaireService;

	
	@GetMapping("")
	public List<Gestionnaire> getGestioannaires(){
		return gestionnaireService.getAll();
	}
	@PostMapping("/register")
	public Gestionnaire createGestionnaire(@RequestBody RegisterForm gestionnaireForm) {
		if(!gestionnaireForm.getPassword().equals(gestionnaireForm.getRepassword())) throw
		new RuntimeCryptoException("You must confirm your password");
		Gestionnaire gestionnaire = gestionnaireService.findByUsername(gestionnaireForm.getUsername());
		if(gestionnaire!=null) throw new RuntimeCryptoException("this user alreeady exists !");
		Gestionnaire g = new Gestionnaire();
		g.setUsername(gestionnaireForm.getUsername());
		g.setPassword(gestionnaireForm.getPassword());
		gestionnaireService.saveGestionnaire(g);
		System.out.println(g.getUsername());
		gestionnaireService.addRoleToGestionnaire(gestionnaireForm.getUsername(), "ADMIN");
		return g;

	}
	@PutMapping("/update_gestionnaire")
	public void updateGestionnaire(@RequestBody Gestionnaire gestionnaire, @PathVariable Long id) {
		gestionnaireService.updateGestionnaire(gestionnaire, id);
	}
	@DeleteMapping("/delete")
	public void deleteGestionnaire(@RequestBody Gestionnaire gestionnaire) {
		gestionnaireService.delete(gestionnaire);
	}
	
	
	
	
	
	
	
	

}
