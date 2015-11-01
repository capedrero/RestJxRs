package com.edreams.main.controller;

import java.util.Collection;

import com.edreams.main.bean.Flight;
import com.edreams.main.offer.IStrategyFlightOffer;
import com.edreams.main.service.FlightService;

public class ManagerFlightOffers{
	private FlightService flightService;
	


	public void process(IStrategyFlightOffer[] aStrategyOffers) throws Exception{
		flightService = new FlightService(); 
		Collection<Flight> flights = flightService.getFlights();
		for (Flight flight : flights) {
			for (IStrategyFlightOffer strategyOffer : aStrategyOffers) {
				strategyOffer.processOffer(flight);
			}
			
		}
		flightService.saveFlights(flights);		
	}
}
