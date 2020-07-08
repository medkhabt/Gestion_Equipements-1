package com.ensa.rest;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Autorisation;
import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.metier.AutorisationService;
import com.ensa.metier.DemandeService;
import com.ensa.metier.EquipementService;
import com.ensa.metier.GestionnaireService;

@RestController
@RequestMapping("/autorisations")
@EnableWebSecurity
//@CrossOrigin(origins = "*")
public class AutorisationRestController {
	@Autowired
	AutorisationService autorisationService;
	@Autowired
	DemandeService demandeService;
	@Autowired
	EquipementService equipementService;
	@Autowired
	GestionnaireService gestionnaireService;
	
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
	public Autorisation creatAutorisation(@RequestBody Autorisation autorisation) {
		 return autorisationService.createAutorisation(autorisation);
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
	@GetMapping("/par_equipement/{nom}")
	public int[] getAutorisations(@PathVariable String nom) {
		Equipement equipement = equipementService.getEquipement(nom);
		List<Autorisation> autorisations = autorisationService.getAutorisations(equipement);
		int[] autoSomme = {0,0,0,0,0,0,0,0,0,0,0,0} ;
		System.out.println(autorisations.size());
		for(Autorisation autorisation : autorisations) {
			System.out.println(autorisation.getId());
			Date date = autorisation.getDateAutorisation();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			System.out.println(date);
			autoSomme[month] += 1;
			System.out.println(autoSomme[month]);
		}
		return autoSomme;
	}
	@GetMapping("/par_gestionnaire/{id}")
	public int[] getAutorisations(@PathVariable Long id) {
		Gestionnaire gestionnaire = gestionnaireService.findById(id);
		if(gestionnaire==null) {
			throw new RuntimeCryptoException("ce gestionnaire n'existe pas !");
		}
		List<Autorisation> autorisations = autorisationService.getAutorisations(gestionnaire);
		int[] autoSomme = {0,0,0,0,0,0,0,0,0,0,0,0} ;
		for(Autorisation autorisation : autorisations) {
			System.out.println(autorisation.getId());
			Date date = autorisation.getDateAutorisation();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			System.out.println(date);
			autoSomme[month] += 1;
			System.out.println(autoSomme[month]);
		}
		return autoSomme;
	}
	@GetMapping("/par_demandeur")
	public List<Autorisation> getAutorisations(@RequestBody Demandeur demandeur) {
		return autorisationService.getAutorisations(demandeur);
	}
	@GetMapping("/par_gestionnaire")
	public List<Autorisation> getAutorisations(@RequestBody Gestionnaire gestionnaire) {
		return autorisationService.getAutorisations(gestionnaire);
	}
	// create autorisation ==> word
	@GetMapping("/create_doc/{id}")
	public File getDoc(@PathVariable int id) throws Docx4JException {
		return autorisationService.getDoc(id);
	}
	@GetMapping("/get_doc/{id}")
	public String getDocblob(@PathVariable int id) {
		Demande demande = demandeService.getDemande(id);
		System.out.println("fichier word : "+demande.getObligationScanne().length);
//		return demande.getObligationScanne();
		return "obligation";
	}
	@GetMapping("/par_mois")
	public List<Integer> getByMonth() throws ParseException {
		int i;
		List<Integer> autoSomme = new ArrayList<Integer>();
		for(i=1;i<13;i++) {
			List<Autorisation> autorisations = autorisationService.getAutorisationsByMonth(i);
			System.out.println(autorisations.size());
			autoSomme.add(autorisations.size());
		}
		
		return autoSomme;
	}
	
	

	
	
	
	
}
