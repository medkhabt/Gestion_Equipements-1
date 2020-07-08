package com.ensa.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Autorisation;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Taxe;

@Repository
public interface AutorisationRepository extends JpaRepository<Autorisation , Integer> {
	public Autorisation findById(int id);
	public List<Autorisation> findByDateAutorisation(Date dateReservation);
	public List<Autorisation> findByType(String type);
	public Taxe save(Taxe taxe);
	public void deleteById(int id);
	public List<Autorisation> findByDateAutorisationBetween(Date d1, Date d2);
	@Query(value = "FROM Autorisation as a where a.reservation.equipement.id=:idEquipement")
	public List<Autorisation> getAutorisationsByEquipement(@Param("idEquipement") int id);
	@Query(value = "FROM Autorisation as a where a.reservation.gestionnaire.id=:idGestionnaire")
	public List<Autorisation> getAutorisationsByGestionnaire(@Param("idGestionnaire") Long id);

}
