package com.ensa.repo;

import com.ensa.entities.GRole;
import com.ensa.entities.Gestionnaire;

public interface GestionnaireService {
	
	public Gestionnaire saveGestionnaire(Gestionnaire gestionnaire);
	public Gestionnaire findByUsername(String username);
	public GRole saveRole(GRole role);
	public void addRoleToGestionnaire(String username, String rolename);

}
