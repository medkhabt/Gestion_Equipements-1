package com.ensa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Taxe;
import com.ensa.metier.TaxeService;

@RestController
@RequestMapping("taxes")
public class TaxeRestController {
	@Autowired
	TaxeService taxeService;
	
	@GetMapping("")
	public List<Taxe> getTaxes(){
		return taxeService.getAll();
	}
	@PostMapping("/create_taxe")
	public void createTaxe(@RequestBody Taxe taxe) {
		taxeService.createTaxe(taxe);
	}
	@DeleteMapping("/delete_taxe/{id}")
	public void deleteTaxe(@PathVariable int id) {
		taxeService.delete(id);
	}

}
