package com.edreams.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.edreams.main.bean.Flight;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.dao.json.JsonFlightManager;
import com.edreams.main.model.TransformParamsUrlCurrencyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import static com.jayway.restassured.RestAssured.given;

public class TestFlightService {

	@Before
	public void setUp() {
		RestAssured.port=8080;
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.basePath = "/RestJxRs/flightService/";
	}


	@Test
	public void testGetOrderFlightsServiceOrderByTimeDifferenceWithRestAssured() {
		try {
			 Response response = given().contentType(ContentType.JSON).
					queryParam("origin", "Oros").
					queryParam("sorter", "timeDifference").
					queryParam("typeSorter", "asc").
					queryParam("orderBy","EUR").
			when().
					get("/getOrderFlights").
			then().
					statusCode(200).
					 extract().response(); // extract the response
			 String jsonAsString = response.asString();
			 List<Flight> listFligths = getListFlitgsFromJsonWithRootName(jsonAsString);
			 
			 Assert.assertTrue(listFligths.size()>0);
			 Long differencePre= null;
			
			 for (Flight flight : listFligths) {
				 //System.out.println(flight);									
				 Long difference = Math.abs(flight.getDateDeparture().getTime()-flight.getDateArrival().getTime());
				 Assert.assertEquals(flight.getOrigin(), "Oros");	
				 //System.out.println(differencePre+" "+difference);
				 if(differencePre!=null){
					 Assert.assertTrue(difference>differencePre);
				 }
				 differencePre = difference;
							 
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	
	@Test
	public void testGetOrderFlightsServiceOrderByPriceWithRestAssured() {
		try {
			 Response response = given().contentType(ContentType.JSON).
					queryParam("origin", "Oros").
					queryParam("sorter", "price").
					queryParam("typeSorter", "desc").
					queryParam("orderBy","EUR").
			when().
					get("/getOrderFlights").
			then().
					statusCode(200).
					 extract().response(); // extract the response
			 String jsonAsString = response.asString();
			 List<Flight> listFligths = getListFlitgsFromJsonWithRootName(jsonAsString);
			 
			 Assert.assertTrue(listFligths.size()>0);
			 Double price = null;
				TransformParamsUrlCurrencyService.setUrl("http://jarvisai.herokuapp.com/currency?from=");	
				TransformParamsUrlCurrencyService.setRootName("jarvis");
			 for (Flight flight : listFligths) {
				 //System.out.println(flight);	
			
				 Double rate = TransformParamsUrlCurrencyService.getInstance().getRate(flight.getCurrency(), "EUR");
				 Double transformPrice = flight.getPrice()*rate;
				 Assert.assertEquals(flight.getOrigin(), "Oros");	
				// System.out.println(transformPrice+" "+price);	
				 if(price!=null){
					 Assert.assertTrue(transformPrice<price);
				 }
				
				 price = transformPrice;
							 
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	
	private List<Flight> getListFlitgsFromJsonWithRootName(String output) throws IOException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectReader reader = mapper.readerFor(new TypeReference<List<Flight>>() {
		}).withRootName("flight");
		List<Flight> myList = reader.readValue(output);
		return myList;
	}
	

}
