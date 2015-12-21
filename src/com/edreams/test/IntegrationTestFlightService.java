package com.edreams.test;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.edreams.main.bean.Flight;
import com.edreams.main.config.ConfigurationSpring;
import com.edreams.main.config.CurrenciesProperties;
import com.edreams.main.config.FactoryBeans;
import com.edreams.main.model.TransformParamsUrlCurrencyService;
import com.edreams.main.service.ApplicationMainForIntegrationTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMainForIntegrationTest.class)
@WebAppConfiguration
//Random Port 
@IntegrationTest("server.port:0")		
public class IntegrationTestFlightService {

	
	@Value("${local.server.port}")
	private int serverPort;	
	private CurrenciesProperties conf = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(CurrenciesProperties.class);
	 
	 
	@Before
	public void setUp(){
		RestAssured.port=serverPort;
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.basePath = "/RestJxRs/flightService";
	}
	

	
	@Test
	public void testGetOrderFlightsServiceOrderByTimeDifferenceWithRestAssured(){
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
				// System.out.println(flight);									
				 Long difference = Math.abs(flight.getDateDeparture().getTime()-flight.getDateArrival().getTime());
				 Assert.assertEquals(flight.getOrigin(), "Oros");	
				// System.out.println(differencePre+" "+difference);
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
			 
				TransformParamsUrlCurrencyService.setUrl(conf.getUrl());	
				TransformParamsUrlCurrencyService.setRootName(conf.getRootName());
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
		ObjectReader reader = mapper.readerFor(CollectionType.construct(List.class, SimpleType.construct(Flight.class)));				
		
		List<Flight> myList = reader.readValue(output);
		return myList;
	}
}
