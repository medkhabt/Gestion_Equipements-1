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

import com.ensa.entities.Qaid;
import com.ensa.metier.QaidService;

@RestController
@RequestMapping("qaids")
public class QaidRestController {
	@Autowired
	QaidService qaidService;
	
	@GetMapping("")
	public List<Qaid> getQaids() {
		return qaidService.getAll();
	}
	@PostMapping("/create_qaid")
	public void createQaid(@RequestBody Qaid qaid) {
		qaidService.createQaid(qaid);
	}
	@PutMapping("/update_qaid")
	public void updateQaid(@RequestBody Qaid qaid, @RequestBody int id) {
		qaidService.updateQaid(qaid, id);
	}
	@GetMapping("/get_qaidBy_id/{id}")
	public Optional<Qaid> getQaid(@PathVariable int id) {
		return qaidService.getById(id);
	}
	@DeleteMapping("/delete_qaid/{id}")
	public void delete(@PathVariable int id) {
		qaidService.delete(id);
	}
	
	
	
	
	
	

}
