package com.edreams.test;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.edreams.main.bean.Flight;
import com.edreams.main.bean.User;
import com.edreams.main.service.BookingService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestBookingService {
	private Client client;	
	private WebResource webResource;

	@Before
	public void setUp() {
		client = Client.create();
	}

	@Test
	public void testPostBookingService() {
		try {

			webResource = client.resource("http://localhost:8080/RestJxRs/bookingService/insertBooking");

			String input = "[{\"id\":\"1\",\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\"},"
					+ "{\"id\":1,\"origin\":\"Chroyane\",\"destination\":\"Tyria\",\"dateArrival\":\"2015-08-07\",\"dateDeparture\":\"2015-08-08\",\"price\":4789.25,\"currency\":\"GBP\",\"typeOffer\":\"REGULAR\"}]";

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("InsertBooking | Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test
	public void testBook() {
		try {
			BookingService book = new BookingService();
			String input = "{\"id\":\"1\",\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\",\"role\":\"USER\"}";
			User user = new ObjectMapper().readValue(input, User.class);
			input = "{\"id\":1,\"origin\":\"Chroyane\",\"destination\":\"Tyria\",\"dateArrival\":\"2015-08-07\",\"dateDeparture\":\"2015-08-08\",\"price\":4789.25,\"currency\":\"GBP\",\"typeOffer\":\"REGULAR\"}";
			Flight flight = new ObjectMapper().readValue(input, Flight.class);
			book.insertBooking(user, flight);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}

	}
}
