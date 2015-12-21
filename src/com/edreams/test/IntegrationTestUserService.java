package com.edreams.test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.edreams.main.bean.User;
import com.edreams.main.service.ApplicationMainForIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMainForIntegrationTest.class)
@WebAppConfiguration
//Random Port 
@IntegrationTest("server.port:0")		
public class IntegrationTestUserService {

	
	@Value("${local.server.port}")
	private int serverPort;	
	 
	 
	@Before
	public void setUp(){
		RestAssured.port=serverPort;
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.basePath = "/RestJxRs/userService";
	}
	

	@Test
	public void testGetUserService() {
		try {
			 Response response = given().contentType(ContentType.JSON).
						pathParam("id", 2).					
				when().
						get("/getUser/{id}").
				then().
						statusCode(200).
						 extract().response(); 
			 String output = response.asString();
			Assert.assertNotNull(output);
			Assert.assertFalse(output.isEmpty());


		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test
	public void testGetUsersService() {
		try {
			
				 Response response = given().contentType(ContentType.JSON).								
					when().
							get("/getUsers").
					then().
							statusCode(200).
							 extract().response(); 
				 String output = response.asString();
				Assert.assertNotNull(output);
				Assert.assertFalse(output.isEmpty());
					

		

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	/**
	 * Devolucion como Json, no en el response.
	 */
	@Test
	public void testPostUserService() {
		try {
			String input ="{\"id\":\"8\",\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\",\"role\":\"USER\"}";
			User user = new ObjectMapper().readValue(input, User.class);
					 given().contentType(ContentType.JSON).			
					body(user).
					 expect().body("address",equalTo(user.getAddress())).
				when().
						post("/insertUser");		
			

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	@Test
	public void testDeleteUserService() {
		try {

			
			String input = "{\"id\":\"1\",\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\"}";
			User user = new ObjectMapper().readValue(input, User.class);
			
						 given().contentType(ContentType.JSON).			
					body(input).
					 expect().body(equalTo(user.toString())).
				when().
						delete("/deleteUser").
						
				then().
						statusCode(201);	


		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	@Test
	public void testUpdateUserService() {
		try {
			
			String input = "{\"id\":\"1\",\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\",\"role\":\"USER\"}";		
			
			User user = new ObjectMapper().readValue(input, User.class);
			
						 given().contentType(ContentType.JSON).			
					body(input).
					 expect().body(equalTo(user.toString())).
				when().
						put("/updateUser").
						
				then().
						statusCode(201);	
		

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

}
