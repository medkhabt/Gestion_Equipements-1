package com.ensa.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Qaid;
import com.ensa.repo.QaidRepository;

@Service
public class QaidService {
	@Autowired
	QaidRepository qaidRepository;
	
	public Qaid createQaid(Qaid qaid) {
		return qaidRepository.save(qaid);
	}
	public Qaid updateQaid(Qaid qaid, int id) {
		qaid.setId(id);
		return qaidRepository.save(qaid);
	}
	public List<Qaid> getAll(){
		return qaidRepository.findAll();
	}
	public Optional<Qaid> getById(int id) {
		return qaidRepository.findById(id);
	}
	public void delete(int id) {
		qaidRepository.deleteById(id);
	}

}
