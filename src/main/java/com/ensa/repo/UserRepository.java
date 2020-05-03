package com.ensa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByUsername(String userName);
}
