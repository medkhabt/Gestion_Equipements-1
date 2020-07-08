package com.ensa.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Autorisation;
import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.Reservation;
import com.ensa.entities.Secteur;
import com.ensa.repo.GestionnaireRepository;
import com.ensa.repo.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepo;
	@Autowired
	GestionnaireRepository gestionnaireRepo;
	public List<Reservation> getAll(){
		return reservationRepo.findAll();
	}
	public Reservation getReservation(int id) {
		return reservationRepo.findById(id).get();
	}
	public Reservation createReservation(Reservation reservation) {
		return reservationRepo.save(reservation);
	}
	public Reservation updateReservation(Reservation reservation,Long id) {
		Reservation r = reservationRepo.findById(reservation.getId()).get();
		System.out.println(r.getId()+"---- id :"+id);
		Optional<Gestionnaire> g = gestionnaireRepo.findById(id);
		System.out.println(g.get());
//		r.setCommentaire(reservation.getCommentaire());
//		r.setDemande(reservation.getDemande());
//		r.setEquipement(reservation.getEquipement());
//		r.setEtat(reservation.getEtat());
		reservation.setGestionnaire(g.get());
//		r.setAutorisation(reservation.getAutorisation());
		return reservationRepo.save(reservation);
	}
	public List<Reservation> getReservations(Equipement equipement){
		return reservationRepo.findByEquipement(equipement);
	}
	public Reservation getReservation(Demande demande){
		return reservationRepo.findByDemande(demande).get();
	}
	public Reservation getReservation(Gestionnaire gestionnaire) {
		return reservationRepo.findByGestionnaire(gestionnaire).get();
	}
	public void delete(int id) {
		reservationRepo.deleteById(id);
	}
	public void delete(Reservation reservation) {
		reservationRepo.delete(reservation);
	}
	/* Interaction*/
	public List<Reservation> getReservations(Demandeur demandeur){
		List<Demande> demandes = demandeur.getDemandes();
		List<Reservation> reservations = new ArrayList<Reservation>();
		for(Demande demande : demandes) {
			if(this.getReservation(demande)!= null) {
				System.out.println(demande.getId());
				reservations.addAll(demande.getReservations());
				
			}
		}
		return reservations;
	}
	public List<Reservation> getReservations(Secteur secteur){
		List<Equipement> equipements = secteur.getEquipements();
		List<Reservation> reservations = new ArrayList<Reservation>();
		for(Equipement equipement : equipements) {
			reservations.addAll(equipement.getReservations());
		}
		return reservations;
	}
//	public List<Reservation> getReservationsByMonth(int m) throws ParseException {
//		String sdate1 = "01/"+m+"/2020";
//		String sdate2 = "30/"+m+"/2020";
//		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sdate1);
//		Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sdate2);
//		return reservationRepo.(date1, date2);
//	}
	
}
