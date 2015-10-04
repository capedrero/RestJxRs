package com.edreams.test;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.edreams.main.bean.DragonFlightCollection;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestConsumeDragonFlight {

	private Client client;
	private ClientResponse response;
	private WebResource webResource;

	@Before
	public void setUp() {
		client = Client.create();
	}

	@Test
	public void testConsumeDragonFlight() {
		try {

			webResource = client.resource("http://odigeo-testbackend.herokuapp.com");

			response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);

			DragonFlightCollection myObjects = new ObjectMapper().readValue(output, new TypeReference<DragonFlightCollection>() {});		
			System.out.println("List Dragon Flught "+myObjects.getListDragonFlights().size());

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

}
