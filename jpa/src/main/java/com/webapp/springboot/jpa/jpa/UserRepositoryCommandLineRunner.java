package com.webapp.springboot.jpa.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.webapp.springboot.jpa.jpa.entity.User;
import com.webapp.springboot.jpa.jpa.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
   @Autowired
	private UserRepository userRepository;

@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	
	User user = new User("Jill", "Developer");
	userRepository.save(user);
	log.info("New user crested" + user);
	
	Optional<User> userWithId1 = userRepository.findById(1L);
	log.info("User with Id1 is retrived:" + userWithId1);
	
	List<User> users = userRepository.findAll();
	log.info("All Users:" + users);
	
}
	

   
}
