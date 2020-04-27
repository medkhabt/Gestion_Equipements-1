package com.ensa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Demande;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	public Reservation save(Reservation reservation);
	public List<Reservation> findAll();
	public Reservation findById(int id);
	public List<Reservation> findByEquipement(Equipement equipement);
	public Reservation findByDemande(Demande demande);
	public Reservation findByGestionnaire(Gestionnaire gestionnaire);
	public void deleteById(int id);

	
	
}
