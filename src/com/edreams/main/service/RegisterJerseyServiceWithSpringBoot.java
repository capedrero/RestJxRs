package com.edreams.main.service;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/RestJxRs")
public class RegisterJerseyServiceWithSpringBoot extends ResourceConfig {
	 public RegisterJerseyServiceWithSpringBoot() {
	        register(FlightService.class);
	        register(UserService.class);
	        register(BookingService.class);
	    }


	
	
	
}
