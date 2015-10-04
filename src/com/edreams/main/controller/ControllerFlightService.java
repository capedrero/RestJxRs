package com.edreams.main.controller;

import java.util.Collection;
import java.util.Map;

import com.edreams.main.bean.Flight;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.model.ITransformFlightProcess;
import com.edreams.main.model.ModelFlightService;
import com.edreams.main.model.compare.IBuilderComparator;

public class ControllerFlightService<T> {

	private ModelFlightService<T> modelFlightService;
	
	public ControllerFlightService() {
		super();			
		modelFlightService = new ModelFlightService<T>();
	}
	
	public void startDB() throws Exception {
		this.modelFlightService.consumeDragonFlightWebService();
		this.modelFlightService.startDB();
		
	}

	public Collection<Flight> getFlights() {
		return modelFlightService.getFlights();
	}		
	
	public void setTransformFlightProcess(ITransformFlightProcess transformFlightProcess) throws Exception {
		this.modelFlightService.setTransformFlightProcess(transformFlightProcess);
	}
	public void setConsumerRestService(ConsumerRestService<T> consumerRestService){
		this.modelFlightService.setConsumerRestService(consumerRestService);	
	}

	public Collection<Flight> getOrderFlights(String origin, String destin, IBuilderComparator comparator) throws Exception {
		return this.modelFlightService.getOrderFlights(origin, destin, comparator);
	}
	
}
