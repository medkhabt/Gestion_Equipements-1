package com.ensa.metier;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ensa.entities.Decideur;
import com.ensa.entities.GRole;
import com.ensa.entities.Utilisateur;
import com.ensa.repo.DecideurRepository;
import com.ensa.repo.RoleRepositpory;

@Service
public class DecideurService implements com.ensa.repo.DecideurService {

	@Autowired
	DecideurRepository decideurRepo;
	@Autowired
	BCryptPasswordEncoder brBCryptPasswordEncoder;
	@Autowired
	RoleRepositpory roleRepositpory;

	@Override
	public Decideur saveDecideur(Decideur decideur) {
		String hashPW = brBCryptPasswordEncoder.encode(decideur.getPassword());
		decideur.setPassword(hashPW);
		return decideurRepo.save(decideur);
	}

	@Override
	public GRole saveRole(GRole role) {
		return roleRepositpory.save(role);
	}

	@Override
	public void addRoleToDecideur(String username, String rolename) {
		List<GRole> role = roleRepositpory.findByRole(rolename);
		role.forEach(r->{
			System.out.println(r.getRole());
		});
		Utilisateur utilisateur = decideurRepo.findByUsername(username).get();
		
		Iterator<GRole> iter = role.iterator();
		System.out.println(iter.next().getRole());
		utilisateur.setRoles(role);
		
	}

	public Decideur findByUsername(String username) {
		return decideurRepo.findByUsername(username).get();
	}
}
