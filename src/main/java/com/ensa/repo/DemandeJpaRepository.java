package com.ensa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;

@Repository
public interface DemandeJpaRepository extends JpaRepository<Demande, Integer> {
	@SuppressWarnings("unchecked")
	public Demande save(Demande demande);
	public List<Demande> findAll();
	public List<Demande> findByDemandeur(Demandeur demandeur);
	

}
