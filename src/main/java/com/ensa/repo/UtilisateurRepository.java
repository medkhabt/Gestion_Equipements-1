package com.ensa.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensa.entities.Demande;
import com.ensa.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	public Optional<Utilisateur> findByUsername(String username);
	public Optional<Utilisateur> findByNomAndPrenom(String nom, String prenom);
	public Optional<Utilisateur> findByAdresse(String adresse);
	public Optional<Utilisateur> findByTelephone(String telephone);
	public Optional<Utilisateur> findByUsernameAndPassword(String username, String password);
	@Transactional
	public void deleteByUsername(String username);
	@Transactional
	public void delete(Utilisateur Utilisateur);
	@Query(value = "FROM Demande as d where d.id=:i")
	public List<Demande> getDemandes(@Param("i") Long id);

}
