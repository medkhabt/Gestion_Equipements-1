package com.ensa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Decideur;
import com.ensa.entities.Gestionnaire;
import com.ensa.metier.DecideurService;

@RestController
@RequestMapping("decideur")
@Transactional
public class DecideurRestController {

	@Autowired
	DecideurService decideurService;
	
	
	@PostMapping("/register")
	public Decideur createGestionnaire(@RequestBody Decideur decideur) throws Exception{
//		if(!gestionnaireForm.getPassword().equals(gestionnaireForm.getRepassword())) throw
//		new RuntimeCryptoException("You must confirm your password");
//		Gestionnaire gestTest = gestionnaireService.findByUsername(gestionnaire.getUsername());
//		if(gestTest!=null) throw new RuntimeCryptoException("this user alreeady exists !");
		decideurService.saveDecideur(decideur);
		decideurService.addRoleToDecideur(decideur.getUsername(), "Décideur");
		return decideur;

	}
	@GetMapping("/{username}")
	public Decideur getByUsername(@PathVariable String username) {
		return decideurService.findByUsername(username);
	}
}
