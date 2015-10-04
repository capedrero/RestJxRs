package com.edreams.main.model;

import java.util.Map;

import com.edreams.main.bean.DragonFlightCollection;
import com.edreams.main.bean.Flight;

public interface ITransformFlightProcess {
	Map<Integer, Flight> transform(DragonFlightCollection dragonFlightCollection) throws Exception;
}
