package com.edreams.main.offer;

import com.edreams.main.bean.Flight;

public interface IStrategyFlightOffer {

	void processOffer(Flight flight) throws Exception;

}
