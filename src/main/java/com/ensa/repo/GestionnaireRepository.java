package com.ensa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Gestionnaire;

@Repository
public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Long> {
	public Optional<Gestionnaire> findById(Long id);
	public Optional<Gestionnaire> findByUsername(String username);
	
	
	
}
