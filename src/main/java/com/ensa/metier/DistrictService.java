package com.ensa.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.District;
import com.ensa.repo.DistrictRepository;

@Service
public class DistrictService {
	
	@Autowired
	DistrictRepository districtRepo;
	
	public District createDistrict(District district) {
		return districtRepo.save(district);
	}
	public District updateDistrict(District district, int id) {
		district.setId(id);
		return districtRepo.save(district);
	}
	public List<District> getAll(){
		return districtRepo.findAll();
	}
	public void delete(int id) {
		districtRepo.deleteById(id);
	}

}
