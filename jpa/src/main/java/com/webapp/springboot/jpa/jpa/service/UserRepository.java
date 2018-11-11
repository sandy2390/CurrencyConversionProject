package com.webapp.springboot.jpa.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.springboot.jpa.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
	

}
