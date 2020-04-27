package com.ensa.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.RespoAdministratif;
import com.ensa.repo.RespoAdministratifRepository;

@Service
public class RespoAdministratifService {
	@Autowired
	RespoAdministratifRepository respoAdministratifRepository;
	
	public RespoAdministratif createRespo(RespoAdministratif respoAdministratif){
		return respoAdministratifRepository.save(respoAdministratif);
	}
	public RespoAdministratif updateRespo(RespoAdministratif respoAdministratif, int id) {
		respoAdministratif.setId(id);
		return respoAdministratifRepository.save(respoAdministratif);
	}
	public List<RespoAdministratif> getAll(){
		return respoAdministratifRepository.findAll();
	}
	public RespoAdministratif getRespoAdmin(int id) {
		return respoAdministratifRepository.findById(id);
	}
	public void delete(int id) {
		respoAdministratifRepository.deleteById(id);
	}

}
