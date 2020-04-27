package com.ensa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Bacha;

@Repository
public interface BachaRepository extends JpaRepository<Bacha, Integer> {
	

}
