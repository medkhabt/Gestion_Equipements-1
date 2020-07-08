package com.ensa.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Autorisation;
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
		return demandeRepo.findByDateDebutReservation(dateReservation);
	}
//	public List<Demande> getByInterval(Date d1, Date d2){
//		return demandeRepo.findByDateDebutReservationAfterAndDateDebutReservationBefore(d1, d2);
//	}
	public void deleteDemande(int id) {
		demandeRepo.deleteById(id);
	}
	public void deleteDemandeByType(String typeEvent) {
		demandeRepo.deleteByTypeEvent(typeEvent);
	}
	public List<Demande> getDemandesByMonth(int m) throws ParseException {
		String sdate1 = "01/"+m+"/2020";
		String sdate2 = "30/"+m+"/2020";
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sdate1);
		Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sdate2);
		return demandeRepo.findByDateDebutReservationBetween(date1, date2);
	}


}
