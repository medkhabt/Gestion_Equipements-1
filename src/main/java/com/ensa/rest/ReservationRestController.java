package com.ensa.rest;

import java.util.List;

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

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.Reservation;
import com.ensa.entities.Secteur;
import com.ensa.metier.ReservationService;
import com.ensa.metier.DemandeService;
import com.ensa.metier.DemandeurService;;

@RestController
@RequestMapping("reservations")
@EnableWebSecurity
public class ReservationRestController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	private DemandeurService demandeurService;
	@Autowired
	DemandeService demandeService;
	
	@GetMapping("")
	public List<Reservation> getReservations() {
		return reservationService.getAll();
	}
	@GetMapping("/get/{id}")
	public Reservation getReservation(@PathVariable int id) {
		 return reservationService.getReservation(id);
	}
	@PostMapping("/add")
	public Reservation createReservation(@RequestBody Reservation Reservation) {
		 return reservationService.createReservation(Reservation);
	}
	@PutMapping("/update/{id}")
	public void updateReservation(@RequestBody Reservation reservation, @PathVariable int id) {
		reservationService.updateReservation(reservation, id);
	}
	@GetMapping("/by_demande/{id}")
	public  Reservation getReservationByDemande(@PathVariable int id) {
		Demande demande = demandeService.getDemande(id);
		return reservationService.getReservation(demande);
	}
	@GetMapping("/reservations_par_equipement")
	public  List<Reservation> getReservations(@RequestBody Equipement equipement) {
		return reservationService.getReservations(equipement);
	}
	@GetMapping("/reservations_traite_par_gestionnaire")
	public  Reservation getReservation(@RequestBody Gestionnaire gestionnaire) {
		return reservationService.getReservation(gestionnaire);
	}
	@GetMapping("/by_demandeur/{id}")
	public  List<Reservation> getReservations(@PathVariable Long id) {
		System.out.println(id);
		Demandeur demandeur = demandeurService.getDemandeur(id);
		System.out.println(demandeur.getNom());
		return reservationService.getReservations(demandeur);
	}
	@GetMapping("/reservations_par_secteur")
	public  List<Reservation> getReservation(@RequestBody Secteur secteur) {
		return reservationService.getReservations(secteur);
	}
	@DeleteMapping("/delete_reservation/{id}")
	public void delete(@PathVariable int id) {
		reservationService.delete(id);
	}
	
	
	
	
}
