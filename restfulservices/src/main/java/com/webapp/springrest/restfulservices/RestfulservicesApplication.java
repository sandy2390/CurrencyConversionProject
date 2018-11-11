package com.webapp.springrest.restfulservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@SpringBootApplication
public class RestfulservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulservicesApplication.class, args);
	}
	
	
	/*@Bean
	public LocaleResolver localeResolver() {
		
		SessionLocaleResolver localeResolver  = new SessionLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}*/
	
	
	@Bean
	public LocaleResolver localeResolver() {
		
		AcceptHeaderLocaleResolver localeResolver  = new AcceptHeaderLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	/*@Bean
	public ResourceBundleMessageSource resourcebundleMessageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		
		messageSource.setBasename("messages");
		return messageSource;
		
		
		
		
	}*/
	
	/*@Bean
	public ResourceBundleMessageSource resourcebundleMessageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		
		messageSource.setBasename("messages");
		return messageSource;
		
		
		
		
	}*/
	
	
	
}
