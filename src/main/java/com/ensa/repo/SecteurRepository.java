package com.ensa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Qaid;
import com.ensa.entities.Secteur;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer>{
	public Secteur save(Secteur secteur);
	public List<Secteur> findBySurfaceBetween(double L1, double L2);
	public Secteur findByResponsable(String responsable);
	public Qaid save(Qaid qaid);
	public Secteur findById(int id);
	public void deleteById(int id);
	

}
