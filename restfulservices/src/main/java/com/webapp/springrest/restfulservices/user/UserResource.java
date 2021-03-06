package com.webapp.springrest.restfulservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;



@RestController
public class UserResource {
	@Autowired
	private UserDao service;

	@GetMapping("/users")
	public List<User> retreiveAllUsers(){
		
		return service.findAll();
	}
@GetMapping("/user/{id}")
public Resource<User> retriveUser(@PathVariable int id) {
	
	User user = service.findOne(id);
	if(user == null) 
		
		throw new userNotFoundException("id-"+ id);
	
	
	Resource<User> resource = new Resource<User>(user);
	ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retreiveAllUsers());
	resource.add(linkTo.withRel("all-users"));		
	return resource;
	

	
}
@DeleteMapping("/user/{id}")
public void deleteUser(@PathVariable int id) {
	
	User user = service.deleteById(id);
	if(user == null) {
		
		throw new userNotFoundException("id-"+ id);
	}

	}
@PostMapping("/users")
public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
	
	User savedUser = service.save(user);

	URI location=ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	
}

}
