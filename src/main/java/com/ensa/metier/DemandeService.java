package com.ensa.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.repo.DemandeJpaRepository;

@Service
public class DemandeService {
	@Autowired
	DemandeJpaRepository demandeRepo;
	
	public List<Demande> getDemandes(){
		return demandeRepo.findAll();
	}
	public List<Demande> getDemande(Demandeur demandeur) {
		return demandeRepo.findByDemandeur(demandeur);
	}
	public Demande getDemande(int id ) {
		return demandeRepo.findById(id);
	}
	public List<Demande> getDemande(Date datedemande){
		return demandeRepo.findByDateDemande(datedemande);
	}
	public Demande updateDemande(Demande demande, int id) {
		demande.setId(id);
		return demandeRepo.save(demande);
	}
	public Demande createDemande(Demande demande) {
		return demandeRepo.save(demande);
	}
	public List<Demande> getByTypeEvent(String type){
		return demandeRepo.findByTypeEvent(type);
	}
	public List<Demande> getByDateReservation(Date dateReservation){
		return demandeRepo.findByDateReservation(dateReservation);
	}
	public List<Demande> getByInterval(Date d1, Date d2){
		return demandeRepo.findByDateReservationAfterAndDateReservationBefore(d1, d2);
	}
	public void deleteDemande(int id) {
		demandeRepo.deleteById(id);
	}
	public void deleteDemandeByType(String typeEvent) {
		demandeRepo.deleteByTypeEvent(typeEvent);
	}


}
