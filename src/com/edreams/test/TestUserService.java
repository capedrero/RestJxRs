package com.edreams.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestUserService {
	private Client client;
	private ClientResponse response;
	private WebResource webResource;

	@Before
	public void setUp() {
		client = Client.create();
	}

	@Test
	public void testGetUserService() {
		try {

			webResource = client.resource("http://localhost:8080/RestJxRs/userService/getUser/2");

			response = webResource.accept("application/json").get(ClientResponse.class);

			checkResponseError(response);

			String output = response.getEntity(String.class);

			System.out.println("GetUser | Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test
	public void testGetUsersService() {
		try {

			webResource = client.resource("http://localhost:8080/RestJxRs/userService/getUsers");

			response = webResource.accept("application/json").get(ClientResponse.class);

			checkResponseError(response);

			String output = response.getEntity(String.class);

			System.out.println("GetUsers | Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	public void testPostUserService() {
		try {

			client = Client.create();

			webResource = client.resource("http://localhost:8080/RestJxRs/userService/insertUser");

			String input = "{\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\"}";

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("InsertUser | Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	public void testDeleteUserService() {
		try {

			webResource = client.resource("http://localhost:8080/RestJxRs/userService/deleteUser");

			String input = "{\"id\":\"1\",\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\"}";

			response = webResource.type("application/json").delete(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("DeleteUser | Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	public void testUpdateUserService() {
		try {

			webResource = client.resource("http://localhost:8080/RestJxRs/userService/updateUser");

			String input = "{\"id\":\"1\",\"address\":\"Madrid\",\"age\":\"2000\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\"}";

			response = webResource.type("application/json").put(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("UpdateUser | Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

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
