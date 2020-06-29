package com.ensa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Equipement;
import com.ensa.entities.Secteur;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Integer> {
	public Equipement findById(int id);
	public List<Equipement> findAll();
	public Equipement findByIdResponsable(int idrespo);
	public Equipement findByNom(String nom);
	public List<Equipement> findBySecteur(Secteur secteur);
	public Equipement findByLargeurAndLongueur(double largeur, double longueur);
	public void deleteById(int id);
	public void delete(Equipement equipement);
	public List<Equipement> findByEtat(String etat);

}
