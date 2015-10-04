package com.edreams.main.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edreams.main.bean.DragonFlight;
import com.edreams.main.bean.DragonFlightCollection;
import com.edreams.main.bean.Flight;

public class TransformFlights implements ITransformFlightProcess{

	private List<ITransformFlightBean> listTransformProcess;
	
	public TransformFlights(List<ITransformFlightBean> listITransformFlightBean) {
		super();
		this.listTransformProcess = listITransformFlightBean;		
		//TODO
		//this.listTransformProcess.add(new CalculatorRealPrice());
	}
	@Override
	public  Map<Integer, Flight> transform(DragonFlightCollection dragonFlightCollection) throws Exception {
	
		Map<Integer, Flight> mapFlights = new HashMap<>();
		int i = 1;
		Flight flight;
		for (DragonFlight dragonFlight : dragonFlightCollection.getListDragonFlights()) {
			flight =  new Flight();
			flight.setId(i++);			
			for (ITransformFlightBean transformProcess : listTransformProcess) {
				transformProcess.transformDragonFlightToFlight(flight, dragonFlight);				
			}						
			mapFlights.put(flight.getId(), flight);
		}
		return mapFlights;
	}
	
	public void addITransformFlightProcess(ITransformFlightBean iTransformFlightBean){
		listTransformProcess.add(iTransformFlightBean);
	}

}


