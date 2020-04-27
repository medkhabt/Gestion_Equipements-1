package com.ensa.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Bacha;
import com.ensa.repo.BachaRepository;

@Service
public class BachaService {
	@Autowired
	BachaRepository bachaRepository;
	
	public Bacha createBacha(Bacha bacha) {
		return bachaRepository.save(bacha);
	}
	public Bacha updateBacha(Bacha bacha, int id) {
		bacha.setId(id);
		return bachaRepository.save(bacha);
	}
	public List<Bacha> getAll(){
		return bachaRepository.findAll();
	}
	public void delete(int id) {
		bachaRepository.deleteById(id);
	}

}
