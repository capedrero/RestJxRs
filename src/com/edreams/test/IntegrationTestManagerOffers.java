package com.edreams.test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map.Entry;

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
import com.edreams.main.bean.TYPE_FLIGHT_OFFER;
import com.edreams.main.controller.ManagerFlightOffers;
import com.edreams.main.model.TransformOffersService;
import com.edreams.main.offer.IStrategyFlightOffer;
import com.edreams.main.offer.StrategyFlightOffer;
import com.edreams.main.service.ApplicationMainForIntegrationTest;
import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMainForIntegrationTest.class)
@WebAppConfiguration
@IntegrationTest("server.port:57")

public class IntegrationTestManagerOffers {

	private static String FLIGHT_SERVICE_GET_FLIGHTS;

	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setUp() {
		RestAssured.port = serverPort;
		RestAssured.baseURI = "http://localhost";
		RestAssured.basePath = "/RestJxRs/flightService";
		FLIGHT_SERVICE_GET_FLIGHTS = RestAssured.baseURI + ":" + RestAssured.port + RestAssured.basePath
				+ "/getFlights";
	}

	@Test
	public void testExistsAvailableOffers() {

		try {			

			ManagerFlightOffers managerOffers = new ManagerFlightOffers();
			managerOffers.process(
					new IStrategyFlightOffer[] {
							new StrategyFlightOffer("http://odigeo-testbackend.herokuapp.com/discount", "results") },
					FLIGHT_SERVICE_GET_FLIGHTS);
			Collection<Flight> flights = managerOffers.getProcesedFlights();
			Assert.assertNotNull(flights);
			Assert.assertFalse(flights.isEmpty());
			for (Flight flight : flights) {
				//System.out.println(flight);
				Assert.assertEquals(TYPE_FLIGHT_OFFER.OFFER_FLIGHT, flight.getTypeOffer());
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test
	public void testDiscounts() {
		try {
			for (Entry<String, BigDecimal> item : TransformOffersService.getInstance().getDestinationDiscountMap()
					.entrySet()) {
				System.out.println(item.getKey() + " " + item.getValue());
			}
			Assert.assertNotNull(TransformOffersService.getInstance().getDestinationDiscountMap());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	/*private List<Flight> getListFlitgsFromJsonWithRootName(String output) throws IOException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		ObjectReader reader = mapper
				.readerFor(CollectionType.construct(List.class, SimpleType.construct(Flight.class)));
		List<Flight> myList = reader.readValue(output);
		return myList;
	}*/

}
