package com.ensa.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.Reservation;
import com.ensa.entities.Secteur;
import com.ensa.repo.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepo;
	public List<Reservation> getAll(){
		return reservationRepo.findAll();
	}
	public Reservation getReservation(int id) {
		return reservationRepo.findById(id);
	}
	public Reservation createReservation(Reservation reservation) {
		return reservationRepo.save(reservation);
	}
	public Reservation updateReservation(Reservation reservation,int id) {
		reservation.setId(id);
		return reservationRepo.save(reservation);
	}
	public List<Reservation> getReservations(Equipement equipement){
		return reservationRepo.findByEquipement(equipement);
	}
	public Reservation getReservation(Demande demande){
		return reservationRepo.findByDemande(demande);
	}
	public Reservation getReservation(Gestionnaire gestionnaire) {
		return reservationRepo.findByGestionnaire(gestionnaire);
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
				reservations.add(demande.getReservation());
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
	
	
}
