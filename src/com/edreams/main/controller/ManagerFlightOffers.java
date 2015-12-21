package com.edreams.main.controller;

import java.util.ArrayList;
import java.util.List;

import com.edreams.main.bean.Flight;
import com.edreams.main.bean.TYPE_FLIGHT_OFFER;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.dao.IConsumerRestService;
import com.edreams.main.offer.IStrategyFlightOffer;

public class ManagerFlightOffers{
	private List<Flight> procesedFlights;
	


	public void process(IStrategyFlightOffer[] aStrategyOffers, String urlFligts) throws Exception{
		IConsumerRestService consumer = new ConsumerRestService();		
		consumer.setUrl(urlFligts);
		List<Flight> fligths = consumer.consumeServiceToJson(List.class, Flight.class);
		procesedFlights = new ArrayList<>();
		for (Flight flight : fligths) {
			for (IStrategyFlightOffer strategyOffer : aStrategyOffers) {
				strategyOffer.processOffer(flight);
				if(TYPE_FLIGHT_OFFER.OFFER_FLIGHT.equals(flight.getTypeOffer())){
					procesedFlights.add(flight);
				}
			}
			
		}	
	}



	public List<Flight> getProcesedFlights() {
		return procesedFlights;
	}



	
}
