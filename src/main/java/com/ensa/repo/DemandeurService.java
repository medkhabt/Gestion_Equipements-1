package com.ensa.repo;

import com.ensa.entities.Demandeur;
import com.ensa.entities.GRole;

public interface DemandeurService {
	public Demandeur saveGestionnaire(Demandeur demandeur);
	public Demandeur findByUsername(String username);
	public GRole saveRole(GRole role);
	public void addRoleToDemandeur(String username, String rolename);

}
