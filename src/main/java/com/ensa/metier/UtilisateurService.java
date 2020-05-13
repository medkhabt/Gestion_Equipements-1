package com.ensa.metier;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ensa.entities.Demande;
import com.ensa.entities.GRole;
import com.ensa.entities.Utilisateur;
import com.ensa.repo.RoleRepositpory;
import com.ensa.repo.UtilisateurRepository;

@Service
public class UtilisateurService implements com.ensa.repo.UtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepo;
	@Autowired
	RoleRepositpory roleRepositpory;
	@Autowired
	BCryptPasswordEncoder brBCryptPasswordEncoder;
	
	public List<Utilisateur> getAll(){
		return utilisateurRepo.findAll();
	}
	public Utilisateur getUtilisateur(String nom, String prenom) {
		return utilisateurRepo.findByNomAndPrenom(nom, prenom).get();
	}
	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		String hashPW = brBCryptPasswordEncoder.encode(utilisateur.getPassword());
		utilisateur.setPassword(hashPW);
		return utilisateurRepo.save(utilisateur);
	}
	public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long id) {
		utilisateur.setId(id);
		return utilisateurRepo.save(utilisateur);
	}
//	public List<Demandeur> getDemandeurByType(String type) {
//		return demandeurRepo.findByType(type);
//	}
	public Utilisateur getUtilisateurByTel(String telephone) {
		return utilisateurRepo.findByTelephone(telephone).get();
	}
	public Utilisateur getUtilisateurByUserPass(String username, String password) {
		return utilisateurRepo.findByUsernameAndPassword(username, password).get();
	}
	public void delete(Long id) {
		utilisateurRepo.deleteById(id);
	}
	public void delete(String username) {
		utilisateurRepo.deleteByUsername(username);
	}
	public void delete(Utilisateur utilisateur) {
		utilisateurRepo.delete(utilisateur);
	}
	@Override
	public GRole saveRole(GRole role) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addRoleToUtilisateur(String username, String rolename) {
		List<GRole> role = roleRepositpory.findByRole(rolename);
		role.forEach(r->{
			System.out.println(r.getRole());
		});
		Utilisateur utilisateur = utilisateurRepo.findByUsername(username).get();
		
		Iterator<GRole> iter = role.iterator();
		System.out.println(iter.next().getRole());
		utilisateur.setRoles(role);
		
	}
	@Override
	public Utilisateur findByUsername(String username) {
		return utilisateurRepo.findByUsername(username).get();
	}
	public List<Demande> getDemandes(Long id) {
		return utilisateurRepo.getDemandes(id);
	}


}
