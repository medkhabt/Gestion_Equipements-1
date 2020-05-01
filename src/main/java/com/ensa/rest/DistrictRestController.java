package com.ensa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.District;
import com.ensa.metier.DistrictService;

@RestController
@RequestMapping("districts")
public class DistrictRestController {
	@Autowired
	DistrictService districtService;
	
	@GetMapping("")
	public List<District> getDistricts() {
		return districtService.getAll();
	}
	@PostMapping("/create_district")
	public District createDistrict(@RequestBody District district) {
		return districtService.createDistrict(district);
	}
	@PutMapping("/update_district")
	public void updateDistrict(@RequestBody District district, @RequestBody int id) {
		 districtService.updateDistrict(district, id);
	}
	@DeleteMapping("/delete_district/{id}")
	public void deleteDistrict(@PathVariable int id) {
		districtService.delete(id);
	}
	
	
	
	
	

}
