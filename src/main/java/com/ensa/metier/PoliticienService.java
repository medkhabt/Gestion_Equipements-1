package com.ensa.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Politicien;
import com.ensa.repo.PoliticienRepository;

@Service
public class PoliticienService {
	@Autowired
	PoliticienRepository politicienRepository;
	
	public Politicien createPoliticien(Politicien politicien) {
		return politicienRepository.save(politicien);
	}
	public Politicien updatePoliticien(Politicien politicien, int id) {
		politicien.setId(id);
		return politicienRepository.save(politicien);
	}
	public List<Politicien> getAll(){
		return politicienRepository.findAll();
	}
	public Optional<Politicien> getPoliticien(int id) {
		return politicienRepository.findById(id);
	}
	public void delete(int id) {
		politicienRepository.deleteById(id);
	}


}
