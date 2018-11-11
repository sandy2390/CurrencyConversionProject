package com.webapp.springboot.jpa.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.webapp.springboot.jpa.jpa.entity.User;
import com.webapp.springboot.jpa.jpa.service.UserDAOService;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDaoService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user =new User("Jack","Admin");
		long insert = userDaoService.insert(user);
		log.info("New user is created"+ user);
		
	}
	



}
