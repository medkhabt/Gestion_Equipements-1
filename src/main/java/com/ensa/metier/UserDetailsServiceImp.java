package com.ensa.metier;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.Utilisateur;
import com.ensa.repo.DemandeurRepository;
import com.ensa.repo.GestionnaireRepository;
import com.ensa.repo.UserRepository;

@Service
public class UserDetailsServiceImp implements org.springframework.security.core.userdetails.UserDetailsService  {
//	@Autowired
//	GestionnaireRepository userRepository;
	@Autowired
	UserRepository userRepository;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Gestionnaire gestionnaire = userRepository.findByUsername(username).get();
//		if( gestionnaire ==null ) throw new UsernameNotFoundException(username);
//		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		gestionnaire.getRoles().forEach(r->{
//			authorities.add(new SimpleGrantedAuthority(r.getRole()));
//		});
//		
//		return new User(gestionnaire.getUsername(), gestionnaire.getPassword(), authorities);
//	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = userRepository.findByUsername(username).get();
		if( utilisateur ==null ) throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		utilisateur.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRole()));
		});
		
		return new User(utilisateur.getUsername(), utilisateur.getPassword(), authorities);
	}
	

	
}
