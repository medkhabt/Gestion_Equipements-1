package com.ensa;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ensa.entities.Demandeur;
import com.ensa.repo.DemandeJpaRepository;
import com.ensa.repo.DemandeurRepository;

@SpringBootApplication
public class Pfa00Application {
	@Autowired
	DemandeJpaRepository demandeJpaRepository;


	public static void main(String[] args) {
		SpringApplication.run(Pfa00Application.class, args);
		ConfigurableApplicationContext ctx =  SpringApplication.run(Pfa00Application.class, args);
		DemandeurRepository dj = ctx.getBean(DemandeurRepository.class);
	
		System.out.println("avant");
		Demandeur d= new Demandeur("ahmed","123","ah","pre",null,null,null,null);
		dj.save(d);
		System.out.println(d.toString());
		System.out.println("apres");
		
	}
	public void run(String...args) throws Exception {
//		demandeJpaRepository.save(new Demande(1,"etat1"));
//		demandeJpaRepository.save(new Demande(2,"etat2"));
//		demandeJpaRepository.findAll().forEach(p->{
//			System.out.println(p.toString());
//		});
		

	}
	
	// you can see the new branch now ???


}
