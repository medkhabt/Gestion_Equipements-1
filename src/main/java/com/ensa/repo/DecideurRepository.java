package com.ensa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Decideur;

@Repository
public interface DecideurRepository extends JpaRepository<Decideur, Long> {

	public Optional<Decideur> findById(Long id);
	public Optional<Decideur> findByUsername(String username);
	
}
