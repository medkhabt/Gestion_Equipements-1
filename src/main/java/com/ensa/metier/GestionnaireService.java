package com.ensa.metier;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.entities.Gestionnaire;
import com.ensa.entities.GRole;
import com.ensa.repo.GestionnaireRepository;
import com.ensa.repo.RoleRepositpory;

@Service
@Transactional
public class GestionnaireService implements com.ensa.repo.GestionnaireService {
	@Autowired
	GestionnaireRepository gestionnaireRepo;
	@Autowired
	BCryptPasswordEncoder brBCryptPasswordEncoder;
	@Autowired
	RoleRepositpory roleRepositpory;
	
	@Override
	public Gestionnaire saveGestionnaire(Gestionnaire gestionnaire) {
		String hashPW = brBCryptPasswordEncoder.encode(gestionnaire.getPassword());
		gestionnaire.setPassword(hashPW);
		return gestionnaireRepo.save(gestionnaire);
	}
	public Gestionnaire updateGestionnaire(Gestionnaire gestionnaire, Long id) {
		gestionnaire.setId(id);
		return gestionnaireRepo.save(gestionnaire);
	}
	public List<Gestionnaire> getAll(){
		return gestionnaireRepo.findAll();
	}
	public void delete(Gestionnaire gestionnaire) {
		gestionnaireRepo.delete(gestionnaire);
	}
	@Override
	public GRole saveRole(GRole role) {
		return roleRepositpory.save(role);
	}
	@Override
	public void addRoleToGestionnaire(String username, String rolename) {
		List<GRole> role = roleRepositpory.findByRole(rolename);
		role.forEach(r->{
			System.out.println(r.getRole());
		});
		Gestionnaire gestionnaire = gestionnaireRepo.findByUsername(username);
		
		Iterator<GRole> iter = role.iterator();
		System.out.println(iter.next().getRole());
		gestionnaire.setRoles(role);
		
		
	}
	@Override
	public Gestionnaire findByUsername(String username) {
		return gestionnaireRepo.findByUsername(username);
	}


}
