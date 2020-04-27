package com.ensa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.RespoAdministratif;

@Repository
public interface RespoAdministratifRepository extends	JpaRepository<RespoAdministratif, Integer> {
	public RespoAdministratif save(RespoAdministratif respoAdministratif);
	public List<RespoAdministratif> findAll();
	public RespoAdministratif findById(int id);
	public RespoAdministratif findByNomAndPrenom(String nom, String prenom);
	public void deleteById(int id);

}
