package com.ensa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Gestionnaire;
import com.ensa.entities.User;

@Repository
public interface GestionnaireRepository extends JpaRepository<Gestionnaire, String> {
	
	public Gestionnaire findByUsername(String username);
	
}
