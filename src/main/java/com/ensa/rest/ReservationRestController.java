package com.ensa.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.Transactional;
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

import io.jsonwebtoken.ExpiredJwtException;

import com.ensa.metier.DemandeService;
import com.ensa.metier.DemandeurService;;

@RestController
@RequestMapping("reservations")
@EnableWebSecurity
@Transactional
public class ReservationRestController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	private DemandeurService demandeurService;
	@Autowired
	DemandeService demandeService;
	
	@GetMapping("")
	public List<Reservation> getReservations() throws ExpiredJwtException{
		return reservationService.getAll();
	}
	@GetMapping("/get/{id}")
	public Reservation getReservation(@PathVariable int id) {
		Reservation reservation = reservationService.getReservation(id);
		Reservation r = new Reservation(reservation);
		Demande d = new Demande(reservation.getDemande());
		if(reservation.getDemande().getObligationScanne()!=null) {
			d.setObligationScanne(decompressBytes(reservation.getDemande().getObligationScanne()));
			r.setDemande(d);
		}
		return r;
	}
	@PostMapping("/add")
	public Reservation createReservation(@RequestBody Reservation Reservation) {
		 return reservationService.createReservation(Reservation);
	}
	@PutMapping("/update/{id}")
	public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable Long id) throws Exception {
		return reservationService.updateReservation(reservation, id);
	}
	@GetMapping("/by_demande/{id}")
	public  Reservation getReservationByDemande(@PathVariable int id) {
		Demande demande = demandeService.getDemande(id);
		return reservationService.getReservation(demande);
	}
	@GetMapping("/par_equipement_etat/{etat}+{equipement}")
	public  List<Reservation> getReservations(@PathVariable String etat, @PathVariable int equipement) {
		return reservationService.getByEquipementAndEtat(etat, equipement);
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
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	
	
	
}
