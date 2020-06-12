package com.ensa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {

	public Optional<Utilisateur> findByUsername(String username);
	

}
