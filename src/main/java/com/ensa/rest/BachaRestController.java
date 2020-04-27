package com.ensa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Bacha;
import com.ensa.metier.BachaService;

@RestController
@RequestMapping("bachas")
public class BachaRestController {
	@Autowired
	BachaService bachaService;
	
	@GetMapping("")
	public List<Bacha> getBachas(){
		return bachaService.getAll();
	}
	@PostMapping("/create_bacha")
	public Bacha createBacha(@RequestBody Bacha bacha) {
		return bachaService.createBacha(bacha);
	}
	@PutMapping("/update_bacha")
	public void updateBacha(@RequestBody Bacha bacha, @RequestBody int id) {
		 bachaService.updateBacha(bacha, id);
	}
	@DeleteMapping("/delete_bacha")
	public void deleteBacha(@RequestBody int id) {
		bachaService.delete(id);
	}
	
	
	
	
	
	
	
	

}
