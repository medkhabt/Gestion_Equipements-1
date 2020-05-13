package com.ensa.repo;

import com.ensa.entities.Utilisateur;
import com.ensa.entities.GRole;

public interface UtilisateurService {
	public Utilisateur saveUtilisateur(Utilisateur utilisateur);
	public Utilisateur findByUsername(String username);
	public GRole saveRole(GRole role);
	public void addRoleToUtilisateur(String username, String rolename);

}
