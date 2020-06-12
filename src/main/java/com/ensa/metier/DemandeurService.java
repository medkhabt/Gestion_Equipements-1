package com.ensa.metier;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.GRole;
import com.ensa.entities.Utilisateur;
import com.ensa.repo.DemandeurRepository;
import com.ensa.repo.RoleRepositpory;

@Service
public class DemandeurService implements com.ensa.repo.DemandeurService {
	@Autowired
	DemandeurRepository demandeurRepo;
	@Autowired
	RoleRepositpory roleRepositpory;
	@Autowired
	BCryptPasswordEncoder brBCryptPasswordEncoder;
	
	public List<Demandeur> getAll(){
		return demandeurRepo.findAll();
	}
	public Demandeur getDemandeur(Long id) {
		System.out.println("inside demandeurService");
		return demandeurRepo.findById(id).get();
	}
	public Demandeur getDemandeur(String nom, String prenom) {
		return demandeurRepo.findByNomAndPrenom(nom, prenom).get();
	}
	@Override
	public Demandeur saveDemandeur(Demandeur demandeur) {
		String hashPW = brBCryptPasswordEncoder.encode(demandeur.getPassword());
		demandeur.setPassword(hashPW);
		return demandeurRepo.save(demandeur);
	}
	public Demandeur updateDemandeur(Demandeur demandeur, Long id) {
		Demandeur d = demandeurRepo.findById(id).get();
		System.out.println(d.getNom());
		d.setNom(demandeur.getNom());
		d.setPrenom(demandeur.getNom());
		d.setEmail(demandeur.getEmail());
		d.setType(demandeur.getType());
		d.setTelephone(demandeur.getTelephone());
		d.setAdresse(demandeur.getAdresse());
		return demandeurRepo.save(d);
	}
//	public List<Demandeur> getDemandeurByType(String type) {
//		return demandeurRepo.findByType(type);
//	}
	public Demandeur getDemandeurByTel(String telephone) {
		return demandeurRepo.findByTelephone(telephone).get();
	}
	public Demandeur getDemandeurByUserPass(String username, String password) {
		return demandeurRepo.findByUsernameAndPassword(username, password).get();
	}
	public void delete(Long id) {
		demandeurRepo.deleteById(id);
	}
	public void delete(String username) {
		demandeurRepo.deleteByUsername(username);
	}
	@Override
	public GRole saveRole(GRole role) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addRoleToDemandeur(String username, String rolename) {
		List<GRole> role = roleRepositpory.findByRole(rolename);
		Utilisateur utilisateur = demandeurRepo.findByUsername(username).get();
		Iterator<GRole> iter = role.iterator();
		System.out.println(iter.next().getRole());
		utilisateur.setRoles(role);
		
	}
	@Override
	public Demandeur findByUsername(String username) {
//		Demandeur demandeur = demandeurRepo.findByUsername(username).get();
//		Demandeur d = new Demandeur(demandeur);
//		System.out.println(d+"---"+demandeur);
//		System.out.println(demandeur.getRecepisse());
//		byte[] recepisse = decompressBytes(demandeur.getRecepisse());
//		byte[] statut = decompressBytes(demandeur.getStatut());
//		byte[] imageProfile = decompressBytes(demandeur.getImageProfile());
//		
//		d.setRecepisse(recepisse);
//		d.setImageProfile(statut);
//		d.setStatut(imageProfile);
//		System.out.println(d.getRecepisse()+"---"+demandeur.getRecepisse());
		return demandeurRepo.findByUsername(username).get();
	}
	public List<Demande> getDemandes(Long id) {
		return this.demandeurRepo.getDemandes(id);
	}
//	public Demandeur findByDemande(int id) {
//		return this.demandeurRepo.getDemandeurByDemande(id);
//	}
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		System.out.println("decompress");
		return outputStream.toByteArray();
	}


}
