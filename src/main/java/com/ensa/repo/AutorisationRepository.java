package com.ensa.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Autorisation;
import com.ensa.entities.Taxe;

@Repository
public interface AutorisationRepository extends JpaRepository<Autorisation , Integer> {
	public Autorisation save(Autorisation autorisation);
	public Autorisation findById(int id);
	public List<Autorisation> findByDateReservation(Date dateReservation);
	public List<Autorisation> findByType(String type);
	public Taxe save(Taxe taxe);
	public void deleteById(int id);
	

}
