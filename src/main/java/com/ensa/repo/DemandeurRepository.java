package com.ensa.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;

@Repository
public interface DemandeurRepository extends JpaRepository<Demandeur, Long> {
	
	public Optional<Demandeur> findByUsername(String username);
	public Optional<Demandeur> findByNomAndPrenom(String nom, String prenom);
	public Optional<Demandeur> findByAdresse(String adresse);
	public Optional<Demandeur> findByTelephone(String telephone);
	public Optional<Demandeur> findByUsernameAndPassword(String username, String password);
	@Transactional
	public void deleteByUsername(String username);
	public void delete(Demandeur demandeur);
	@Query(value = "FROM Demande as d where d.demandeur.id=:i")
	public List<Demande> getDemandes(@Param("i") Long id);
	@Query(value = "select d.demandeur FROM Demande as d where d.id=:idDemande")
	public Demandeur getDemandeurByDemande(@Param("idDemande") int id);
}
