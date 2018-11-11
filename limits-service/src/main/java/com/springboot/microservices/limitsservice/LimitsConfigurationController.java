package com.springboot.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	
@Autowired
private Configuration configuration;
	
@GetMapping("/limits")
public LimitsConfiguration retreiveLimitsConfiguration() {
	
	return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
	
}

@GetMapping("/fault-tolerant-example")
@HystrixCommand(fallbackMethod="fallBackRetreiveConfiguration")
public LimitsConfiguration retreiveConfiguration() {
	
	throw new RuntimeException("Not Available");
}
	
	
public LimitsConfiguration fallBackRetreiveConfiguration() {
	
return new LimitsConfiguration(1000, 10);
}



}
