package com.edreams.main.model;

import java.util.Collection;

import com.edreams.main.bean.DragonFlightCollection;
import com.edreams.main.bean.Flight;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.dao.ManagerFlightDB;
import com.edreams.main.model.compare.IBuilderComparator;

public class ModelFlightService {
	private DragonFlightCollection dragonFlightCollection;
	private ManagerFlightDB dao;	
	private ITransformFlightProcess transformFlightProcess;
	private ConsumerRestService consumerRestService;

	public ModelFlightService() {
		super();
		this.dao = new ManagerFlightDB();		
	}

	public void consumeDragonFlightWebService() throws Exception{			
		this.dragonFlightCollection =  consumerRestService.consumeServiceToJson(DragonFlightCollection.class);
	}
	public void startDB() throws Exception{	
		dao.startDB(transformFlightProcess.transform(this.dragonFlightCollection));
	}

	public Collection<Flight> getFlights() {
		return dao.getFlights();
	}
	
	public void setTransformFlightProcess(ITransformFlightProcess transformFlightProcess){
		this.transformFlightProcess = transformFlightProcess;
	}
	
	public void setConsumerRestService(ConsumerRestService consumerRestService){
		this.consumerRestService =  consumerRestService;
	}
	public Collection<Flight> getOrderFlights(String origin, String destin, IBuilderComparator builderComparator) throws Exception {
		return this.dao.getOrderFlights(origin, destin, builderComparator.getComparator());
	}

	public void saveFlights(final Collection<Flight> flightCollection) throws Exception {
		this.dao.saveFlights(flightCollection);
	}
	
}
