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

import com.ensa.entities.RespoAdministratif;
import com.ensa.metier.RespoAdministratifService;

@RestController
@RequestMapping("responsablesAdministratifs")
public class RespoAdministratifRestController {
	@Autowired
	RespoAdministratifService respoAdminService;
	
	@GetMapping("")
	public List<RespoAdministratif> getRespoAdministratifs() {
		return respoAdminService.getAll();
	}
	@PostMapping("/create_RespoAdministratif")
	public RespoAdministratif createRespoAdministratif(@RequestBody RespoAdministratif RespoAdministratif) {
		return respoAdminService.createRespo(RespoAdministratif);
	}
	@PutMapping("/update_RespoAdministratif")
	public void updateRespoAdministratif(@RequestBody RespoAdministratif RespoAdministratif, @RequestBody int id) {
		 respoAdminService.updateRespo(RespoAdministratif, id);
	}
	@DeleteMapping("/delete_RespoAdministratif/{id}")
	public void deleteRespoAdministratif(@PathVariable int id) {
		respoAdminService.delete(id);
	}

}
