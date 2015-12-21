package com.edreams.test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.edreams.main.bean.Booking;
import com.edreams.main.bean.Flight;
import com.edreams.main.bean.User;
import com.edreams.main.service.ApplicationMainForIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMainForIntegrationTest.class)
@WebAppConfiguration
//Random Port 
@IntegrationTest("server.port:0")	
public class IntegrationTestBookingService {
	@Rule 
	public ExpectedException exception = ExpectedException.none();
	
	@Value("${local.server.port}")
	
	private int serverPort;	
	 
	 
	@Before
	public void setUp(){
		RestAssured.port=serverPort;
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.basePath = "/RestJxRs/bookingService";
	}
	
	@Test	
	public void testPostBookingService() {
		try {		


			String input = "{\"id\":\"1\",\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\",\"role\":\"USER\"}";
			User user = new ObjectMapper().readValue(input, User.class);
			input = "{\"id\":1,\"origin\":\"Chroyane\",\"destination\":\"Tyria\",\"dateArrival\":\"2015-08-07\",\"dateDeparture\":\"2015-08-08\",\"price\":4789.25,\"currency\":\"GBP\",\"typeOffer\":\"REGULAR\"}";
			Flight flight = new ObjectMapper().readValue(input, Flight.class);
			Booking book = new Booking();
			book.setFlight(flight);
			book.setUser(user);			
			
						 given().contentType(ContentType.JSON).			
					body(book).
					 expect().body("bookingID", equalTo(1)).
				when().
						post("/insertBooking");							
		
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	
}
