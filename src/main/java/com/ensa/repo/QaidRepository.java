package com.ensa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Qaid;

@Repository
public interface QaidRepository extends JpaRepository<Qaid, Integer> {

}
