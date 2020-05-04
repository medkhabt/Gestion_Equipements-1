package com.ensa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.GRole;

@Repository
public interface RoleRepositpory extends JpaRepository<GRole, Long> {

	public List<GRole> findByRole(String role);
	
}
