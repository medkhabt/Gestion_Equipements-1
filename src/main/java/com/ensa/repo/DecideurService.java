package com.ensa.repo;

import com.ensa.entities.Decideur;
import com.ensa.entities.GRole;

public interface DecideurService {

	public Decideur saveDecideur(Decideur decideur);
	public GRole saveRole(GRole role);
	public void addRoleToDecideur(String username, String rolename);


}
