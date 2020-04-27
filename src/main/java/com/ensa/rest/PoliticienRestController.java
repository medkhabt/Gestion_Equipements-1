package com.ensa.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Politicien;
import com.ensa.metier.PoliticienService;

@RestController
@RequestMapping("politiciens")
public class PoliticienRestController {
	@Autowired
	PoliticienService politicienService;
	
	@GetMapping("")
	public List<Politicien> getPoliticiens() {
		return politicienService.getAll();
	}
	@GetMapping("/get_politicien/{id}")
	public Optional<Politicien> getPoliticien(@PathVariable int id) {
		return politicienService.getPoliticien(id);
	}
	@PostMapping("/create_politicien")
	public void createPoliticien(@RequestBody Politicien politicien	) {
		politicienService.createPoliticien(politicien);
	}
	@PutMapping("/update_politicien")
	public void updatePoliticien(@RequestBody Politicien politicien, @RequestBody int id) {
		politicienService.updatePoliticien(politicien, id);
	}
	@DeleteMapping("/delete_politicien/{id}")
	public void delete(@PathVariable int id) {
		politicienService.delete(id);
	}
	
	
	
	
	

}
