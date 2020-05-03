package com.ensa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ensa.entities.Gestionnaire;
import com.ensa.entities.GestionnairePrincipal;
import com.ensa.repo.GestionnaireRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService  {
	@Autowired
	GestionnaireRepository userRepository;
	
	public UserDetails loadUserByUsername(String userName) {
//		Gestionnaire user = userRepository.findByUsername(userName);
//		GestionnairePrincipal userDetail = new GestionnairePrincipal(user);
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		return userDetail;
		GestionnairePrincipal gp = new GestionnairePrincipal(new Gestionnaire("foo","foo",null,null,null,null));
		return gp;
	}
	
}
