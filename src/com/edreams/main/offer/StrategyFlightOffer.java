package com.edreams.main.offer;

import java.math.BigDecimal;

import com.edreams.main.bean.Flight;
import com.edreams.main.bean.TYPE_FLIGHT_OFFER;
import com.edreams.main.model.TransformOffersService;

public class StrategyFlightOffer implements IStrategyFlightOffer{
	private String urlRestOfferService;
	private String rootName;

	
	public StrategyFlightOffer(String urlRestOfferService, String rootName) {
		super();
		this.urlRestOfferService = urlRestOfferService;
		this.rootName = rootName;
	}


	@Override
	public void processOffer(Flight flight) throws Exception {
		TransformOffersService.setUrl(urlRestOfferService);
		TransformOffersService.setRootName(rootName);
		BigDecimal rate =TransformOffersService.getInstance().getDiscount(flight.getDestination());
		if(rate!=null){
			flight.setPrice(flight.getPrice()*rate.doubleValue());
			flight.setTypeOffer(TYPE_FLIGHT_OFFER.OFFER_FLIGHT);
		}
	}

}
