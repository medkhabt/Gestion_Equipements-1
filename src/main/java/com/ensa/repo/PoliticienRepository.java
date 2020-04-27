package com.ensa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Politicien;

@Repository
public interface PoliticienRepository extends JpaRepository<Politicien, Integer>{
	

}
