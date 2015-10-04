package com.edreams.main.model;

import com.edreams.main.bean.DragonFlight;
import com.edreams.main.bean.Flight;

public class FlightBeanTranslator  implements ITransformFlightBean{
	
	@Override
	public void transformDragonFlightToFlight(Flight flight, final DragonFlight dragonFlight) throws Exception {		
		flight.setOrigin(dragonFlight.getOutBound().getOrigin());
		flight.setDestination(dragonFlight.getInBound().getOrigin());
		flight.setDateDeparture(SIMPLE_DATE_FORMAT.parse(dragonFlight.getOutBound().getDepartureDate().concat(" ").concat(dragonFlight.getOutBound().getDepartureTime())));
		flight.setDateArrival(SIMPLE_DATE_FORMAT.parse(dragonFlight.getInBound().getArrivalDate().concat(" ").concat(dragonFlight.getInBound().getArrivalTime())));
		flight.setPrice(dragonFlight.getPrice());
		flight.setCurrency(dragonFlight.getCurrency());				
	}
}
