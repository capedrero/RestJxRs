package com.edreams.main.model;

import java.util.Collection;

import com.edreams.main.bean.DragonFlightCollection;
import com.edreams.main.bean.Flight;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.dao.ManagerFlightDB;
import com.edreams.main.model.compare.IBuilderComparator;

public class ModelFlightService <T>{
	private DragonFlightCollection dragonFlightCollection;
	private ManagerFlightDB dao;	
	private ITransformFlightProcess transformFlightProcess;
	private ConsumerRestService<T> consumerRestService;

	public ModelFlightService() {
		super();
		this.dao = new ManagerFlightDB();		
	}

	public void consumeDragonFlightWebService() throws Exception{			
		this.dragonFlightCollection = (DragonFlightCollection) consumerRestService.consumeServiceToJson();
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
	
	public void setConsumerRestService(ConsumerRestService<T> consumerRestService){
		this.consumerRestService =  consumerRestService;
	}
	public Collection<Flight> getOrderFlights(String origin, String destin, IBuilderComparator builderComparator) throws Exception {
		return this.dao.getOrderFlights(origin, destin, builderComparator.getComparator());
	}
	
}
