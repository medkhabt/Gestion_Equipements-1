package com.ensa.metier;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entities.Autorisation;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Equipement;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.Reservation;
import com.ensa.repo.AutorisationRepository;

@Service
public class AutorisationService {
	@Autowired
	AutorisationRepository autorisationRepo;
	@Autowired
	ReservationService reservationService;
	
	public Autorisation createAutorisation(Autorisation  autorisation) {
		return autorisationRepo.save(autorisation);
	}
	public Autorisation updateAutorisation(Autorisation autorisation, int id) {
		autorisation.setId(id);
		return autorisationRepo.save(autorisation);
	}
	public void deleteAutorisation(int id) {
		autorisationRepo.deleteById(id);
	}
	public List<Autorisation> getAll(){
		return autorisationRepo.findAll();
	}
	public Autorisation getAutosiation(int id) {
		return autorisationRepo.findById(id);
	}
	public List<Autorisation> getAutorisation(Date dateReservation){
		return autorisationRepo.findByDateAutorisation(dateReservation);
	}
	public List<Autorisation> getAutorisationsByMonth(int m) throws ParseException {
		String sdate1 = "01/"+m+"/2020";
		String sdate2 = "30/"+m+"/2020";
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sdate1);
		Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sdate2);
		return autorisationRepo.findByDateAutorisationBetween(date1, date2);
	}
	public List<Autorisation> getAutorisation(String type){
		return autorisationRepo.findByType(type);
	}
	
	public List<Autorisation> getAutorisations(Equipement equipement){
//		List<Reservation> reservations= equipement.getReservations();
		List<Autorisation> autorisations= autorisationRepo.getAutorisationsByEquipement(equipement.getId());
//		for( Reservation reservation : reservations) {
//			autorisations.add(reservation.getAutorisation());
//		}
		return autorisations;
	}
	public List<Autorisation> getAutorisations(Demandeur demandeur){
		List<Reservation> reservations= reservationService.getReservations(demandeur);
		List<Autorisation> autorisations = new ArrayList<>();
		for(Reservation reservation : reservations) {
			autorisations.add(reservation.getAutorisation());
		}
		return autorisations;
	}
	public List<Autorisation> getAutorisations(Gestionnaire gestionnaire){
		List<Autorisation> autorisations= autorisationRepo.getAutorisationsByGestionnaire(gestionnaire.getId());
		return autorisations;
	}
	public File getDoc(int id) throws Docx4JException {
		Autorisation a = autorisationRepo.findById(id);
		WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
		mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
		mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
		File exportFile = new File("welcome.docx");
		a.setFichierWord(exportFile);
		autorisationRepo.save(a);
		wordPackage.save(exportFile);
		return a.getFichierWord();		
	}
	
	
	

}
