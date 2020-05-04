package com.ensa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ensa.entities.Demande;
import com.ensa.entities.Gestionnaire;
import com.ensa.entities.GRole;
import com.ensa.metier.GestionnaireService;
import com.ensa.repo.DemandeJpaRepository;

@SpringBootApplication
public class Pfa00Application  implements CommandLineRunner{
	@Autowired
	DemandeJpaRepository demandeJpaRepository;
	@Autowired
	GestionnaireService gestionnaireService;


	public static void main(String[] args) {
		SpringApplication.run(Pfa00Application.class, args);
	}
	
	public void run(String...args) throws Exception {
//		gestionnaireService.saveGestionnaire(new Gestionnaire("Ahmed","1234"));
//		gestionnaireService.saveGestionnaire(new Gestionnaire("Khalid","1234"));
//		gestionnaireService.saveRole(new GRole("ADMIN","modifier les infos"));
//		gestionnaireService.saveRole(new GRole("INVITE","consulter les infos"));
//		gestionnaireService.addRoleToGestionnaire("Ahmed", "Admin");
//		gestionnaireService.addRoleToGestionnaire("Ahmed", "INVITE");
//		gestionnaireService.addRoleToGestionnaire("khalid", "INVITE");

//		
//		demandeJpaRepository.save(new Demande(1,"etat1",null,null,null,null,null));
//		demandeJpaRepository.save(new Demande(2,"etat2",null,null,null,null,null));
		demandeJpaRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    return bCryptPasswordEncoder;
	}

	
	// you can see the new branch now ???


}
