package com.webapp.springrest.restfulservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class userNotFoundException extends RuntimeException {

	public userNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
}
