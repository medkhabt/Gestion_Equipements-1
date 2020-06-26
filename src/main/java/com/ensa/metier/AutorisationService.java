package com.ensa.metier;

import java.io.File;
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
		return autorisationRepo.findByDateReservation(dateReservation);
	}
	public List<Autorisation> getAutorisation(String type){
		return autorisationRepo.findByType(type);
	}
	
	public List<Autorisation> getAutorisations(Equipement equipement){
		List<Reservation> reservations= equipement.getReservations();
		List<Autorisation> autorisations= new ArrayList<Autorisation>();
		for( Reservation reservation : reservations) {
			autorisations.add(reservation.getAutorisation());
		}
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
		List<Reservation> reservations = gestionnaire.getReservations();
		List<Autorisation> autorisations= new ArrayList<Autorisation>();
		for( Reservation reservation : reservations) {
			autorisations.add(reservation.getAutorisation());
		}
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
