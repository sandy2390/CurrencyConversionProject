package com.webapp.springrest.restfulservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private MessageSource MsgSource;
	
	@RequestMapping(method=RequestMethod.GET, path="/welcome")
	public String helloWorld() {
		
		return "Hello World";
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/Bean")
	public HelloWorldBean HelloWorldBean() {
		
		return new HelloWorldBean("This is HelloWorldBean");
	}
	
	
	@RequestMapping(method=RequestMethod.GET, path="/Bean/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("HelloWorld, %s", name));
	}
	

	
	@GetMapping(path="/Internationalized")
	public String hellowWorldInternationalized() {
		
		return MsgSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
	

}
