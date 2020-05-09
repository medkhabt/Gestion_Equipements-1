package com.ensa.metier;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.GRole;
import com.ensa.entities.Gestionnaire;
import com.ensa.repo.DemandeurRepository;
import com.ensa.repo.GestionnaireService;
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
		demandeur.setId(id);
		return demandeurRepo.save(demandeur);
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
		role.forEach(r->{
			System.out.println(r.getRole());
		});
		Demandeur demandeur = demandeurRepo.findByUsername(username).get();
		
		Iterator<GRole> iter = role.iterator();
		System.out.println(iter.next().getRole());
		demandeur.setRoles(role);
		
	}
	@Override
	public Demandeur findByUsername(String username) {
		return this.demandeurRepo.findByUsername(username).get();
	}
	public List<Demande> getDemandes(Long id) {
		return this.demandeurRepo.getDemandes(id);
	}


}
