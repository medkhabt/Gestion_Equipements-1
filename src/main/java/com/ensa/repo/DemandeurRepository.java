package com.ensa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Demandeur;

@Repository
public interface DemandeurRepository extends JpaRepository<Demandeur, Integer> {
	
	public Demandeur save(Demandeur demandeur);
	public List<Demandeur> findAll();
	public Demandeur findByUsername(String username);
	public Demandeur findByNomAndPrenom(String nom, String prenom);
	public Demandeur findByAdresse(String adresse);
	public List<Demandeur> findByType(String type);
	public Demandeur findByTelephone(String telephone);
	public Demandeur findByUsernameAndPassword(String username, String password);
	public void deleteByUsername(String username);
	public void delete(Demandeur demandeur);

}
