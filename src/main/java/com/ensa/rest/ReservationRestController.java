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

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.Reservation;
import com.ensa.entities.Secteur;
import com.ensa.metier.ReservationService;

@RestController
@RequestMapping("reservations")
public class ReservationRestController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("")
	public List<Reservation> getReservations() {
		return reservationService.getAll();
	}
	@GetMapping("/get/{id}")
	public Reservation getReservation(@PathVariable int id) {
		 return reservationService.getReservation(id);
	}
	@PostMapping("/create_reservation")
	public void createReservation(@RequestBody Reservation Reservation) {
		 reservationService.createReservation(Reservation);
	}
	@PutMapping("/update_reservation/{id}")
	public void updateReservation(@RequestBody Reservation reservation, @PathVariable int id) {
		reservationService.updateReservation(reservation, id);
	}
	@GetMapping("/reservation_par_demande")
	public  Reservation getReservation(@RequestBody Demande demande) {
		return reservationService.getReservation(demande);
	}
	@GetMapping("/reservations_en_equipement")
	public  List<Reservation> getReservations(@RequestBody Equipement equipement) {
		return reservationService.getReservations(equipement);
	}
	@GetMapping("/reservations_traite_par_gestionnaire")
	public  Reservation getReservation(@RequestBody Gestionnaire gestionnaire) {
		return reservationService.getReservation(gestionnaire);
	}
	@GetMapping("/reservations_par_demandeur")
	public  List<Reservation> getReservations(@RequestBody Demandeur demandeur) {
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
