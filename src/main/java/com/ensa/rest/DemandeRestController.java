package com.ensa.rest;

import java.util.Date;
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

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.metier.DemandeService;


@RestController
@RequestMapping("/") // /demande   01/05. Med Kha
public class DemandeRestController {
	@Autowired
	DemandeService demandeService;
	
	@GetMapping("demandes/d") // "" 01/05 Med Kha
	public List<Demande> getDemandes(){
		return demandeService.getDemandes();
	}
	@PostMapping("create_demande")
	public void createDemande(@RequestBody Demande demande) {
		 demandeService.createDemande(demande);
	}
	@PutMapping("update_demande/{id}")
	public void updateDemande(@RequestBody Demande demande,@PathVariable int id) {
		 demandeService.updateDemande(demande, id);
	}
	@GetMapping("demande/{id}")
	public Demande getDemande(@PathVariable int id) {
		return demandeService.getDemande(id);
	}
	@GetMapping("demande_demandeur")
	public List<Demande> getDemande(@RequestBody Demandeur demandeur) {
		return demandeService.getDemande(demandeur);
	}
	@GetMapping("demande/DateDemande")
	public List<Demande> getDemande(@RequestBody Date datedemande){
		return demandeService.getDemande(datedemande);
	}
	@DeleteMapping("delete_demande/{id}")
	public void deleteDemande(@PathVariable int id) {
		demandeService.deleteDemande(id);
	}
	@GetMapping("demande_type")
	public List<Demande> getByTypeEvent(@RequestBody String type) {
		return demandeService.getByTypeEvent(type);
	}
	@GetMapping("demande/Date_Reservation")
	public List<Demande> getByDateReservation(@RequestBody Date dateReservation) {
		return demandeService.getByDateReservation(dateReservation);
	}
	@GetMapping("demande/demande_etat/{etat}")
	public List<Demande> getByEtat(@PathVariable String etat) {
		return demandeService.getByEtat(etat);
	}
	@GetMapping("demande/interval_dates")
	public List<Demande> getByInterval(@RequestBody Date d1, @RequestBody Date d2) {
		return demandeService.getByInterval(d1, d2);
	}
	@DeleteMapping("demande/type/{type}")
	public void deleteByType(@PathVariable String typeEvent) {
		demandeService.deleteDemandeByType(typeEvent);
	}
	@DeleteMapping("demande/etat/{etat}")
	public void deleteByEtat(@PathVariable String etat) {
		demandeService.deleteDemandeByEtat(etat);
	}
	
	
	
	
}
