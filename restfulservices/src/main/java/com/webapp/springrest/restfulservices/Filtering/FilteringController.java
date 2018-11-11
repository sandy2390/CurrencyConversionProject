package com.webapp.springrest.restfulservices.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	
	@GetMapping(path="/filtering")
	public MappingJacksonValue userDetails() {
		
		
		SomeBean some= new SomeBean("Sandeep","gourusandeep123@gmail.com","abc");
		
			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "email");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(some);  
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	
	@GetMapping(path="/filtering-list")
	public MappingJacksonValue usersDetailsLists() {
		
		
List<SomeBean> list =Arrays.asList(new SomeBean("Sandeep","gourusandeep123@gmail.com","abc"), new SomeBean("Rajesh", "rajesh@gmail.com", "def"));
		
SomeBean some= new SomeBean("Sandeep","gourusandeep123@gmail.com","abc");
		
SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("email", "password");

	FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	MappingJacksonValue mapping = new MappingJacksonValue(list);  
	mapping.setFilters(filters);
	
	return mapping;
	
		
	}
	
}
