package com.edreams.main.model;

import java.util.List;
import java.util.Map;

import com.edreams.main.bean.DragonFlight;
import com.edreams.main.bean.Flight;

public interface ITransformFlightProcess {
	Map<Integer, Flight> transform(List<DragonFlight> dragonFlightCollection) throws Exception;
}
