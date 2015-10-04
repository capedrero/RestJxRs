package com.edreams.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.edreams.main.bean.Flight;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.dao.json.JsonFlightManager;
import com.edreams.main.model.compare.BuilderComparator;
import com.edreams.main.model.compare.IBuilderComparator;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestFlightService {
	private Client client;
	// private ClientResponse response;
	private WebResource webResource;

	@Before
	public void setUp() {
		client = Client.create();
	}

	@Test
	public void testGetOrderFlightsService() {
		try {

			webResource = client.resource(
					"http://localhost:8080/RestJxRs/flightService/getOrderFlights/sorter/price/typeSorter/EUR");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			checkResponseError(response);

			String output = response.getEntity(String.class);

			System.out.println("GetFlights | Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	public void testGetFlightsService() {
		try {

			ConsumerRestService<Flight> consumer = new ConsumerRestService(
					"http://localhost:8080/RestJxRs/flightService/getFlights", Flight.class);
			Flight list = consumer.consumeServiceToJson();

			// String output = response.accept(MediaType.APPLICATION_JSON);

			// getEntity(String.class);
			JsonFlightManager jsonFlightManager = new JsonFlightManager(new File("c:\\SaveFlight.json"));
			// jsonFlightManager.writeJsonJackson(list);

			/*
			 * System.out.println(\"GetFlights | Output from Server .... \n\");
			 * System.out.println(response.toString());
			 */

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	

	private void checkResponseError(ClientResponse response) {
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
	}
}
