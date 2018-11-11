package com.webapp.springrest.restfulservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

@GetMapping("/personv1")
public PersonV1 personv1() {
	
	return new PersonV1("Sandeep Gouru");
	
}


@GetMapping("/personv2")
public PersonV2 personv2() {
	
	return new PersonV2(new Name("Sandeep","Gouru"));
	
}

@GetMapping(value="/person/param", params="version=1")
public PersonV1 paramv1() {
	
	return new PersonV1("Sandeep Gouru");
	
}


@GetMapping(value="/person/param", params="version=2")
public PersonV2 paramv2() {
	
	return new PersonV2(new Name("Sandeep","Gouru"));
	
}

@GetMapping(value="/person/header", headers="X-Version=1")
public PersonV1 headerv1() {
	
	return new PersonV1("Sandeep Gouru");
	
}


@GetMapping(value="/person/header", headers="X-Version=2")
public PersonV2 headerv2() {
	
	return new PersonV2(new Name("Sandeep","Gouru"));
	
}
@GetMapping(value="/person/produce", produces="application/app-v1+json")
public PersonV1 producesv1() {
	
	return new PersonV1("Sandeep Gouru");
	
}


@GetMapping(value="/person/produce", produces="application/app-v2+json")
public PersonV2 producesv2() {
	
	return new PersonV2(new Name("Sandeep","Gouru"));
	
}

}
