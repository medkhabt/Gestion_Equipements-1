package com.ensa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Bacha;
import com.ensa.entities.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

	public District save(District district);
	public Bacha save(Bacha bacha);
	public District findByResponsable(String responsable);
	public List<District> findBySurfaceBetween(double s1, double s2);
	public District findById(int id);
	public void deleteById(int id);
	
}
