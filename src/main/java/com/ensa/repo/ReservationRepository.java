package com.ensa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	public List<Reservation> findAll();
	public Optional<Reservation> findById(int id);
	public List<Reservation> findByEquipement(Equipement equipement);
	public Optional<Reservation> findByDemande(Demande demande);
	public Optional<Reservation> findByGestionnaire(Gestionnaire gestionnaire);
	public void deleteById(int id);
	@Query(value = " FROM Reservation as r where r.etat=:etat AND r.equipement.id=:equipement")
	public List<Reservation> finByEquipementAndEtat(@Param("etat") String etat, @Param("etat") int id);
	public List<Reservation> findByEtat(String etat);

	
	
}
