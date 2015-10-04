package com.edreams.main.model;

import java.text.SimpleDateFormat;

import com.edreams.main.bean.DragonFlight;
import com.edreams.main.bean.Flight;

public interface ITransformFlightBean {
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	void transformDragonFlightToFlight( Flight flight, DragonFlight dragonFlight) throws Exception;
}
