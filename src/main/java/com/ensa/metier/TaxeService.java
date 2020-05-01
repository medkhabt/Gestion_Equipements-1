package com.ensa.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Taxe;
import com.ensa.repo.TaxeRepository;

@Service
public class TaxeService {
	@Autowired
	TaxeRepository taxeRepository;
	
	public List<Taxe> getAll(){
		return taxeRepository.findAll();
	}
	public Taxe createTaxe(Taxe taxe) {
		return taxeRepository.save(taxe);
	}//à developper
	public void delete(int id) {
		taxeRepository.deleteById(id);
	}

}
