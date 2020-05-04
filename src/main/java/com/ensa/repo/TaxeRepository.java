package com.ensa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Taxe;

@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Integer> {
	

}
