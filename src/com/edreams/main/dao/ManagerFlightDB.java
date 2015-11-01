package com.edreams.main.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.edreams.main.bean.Flight;
import com.edreams.main.dao.json.JsonFlightManager;

public class ManagerFlightDB {
	private Map<Integer, Flight> flightTable;
	private JsonFlightManager jsonManager;

	
	public ManagerFlightDB() {
		super();
		jsonManager = new JsonFlightManager(new File(System.getProperty("user.home")+"\\Flight.json"));
	}
	
	public void readDB() throws Exception{
		flightTable = jsonManager.readJsonJackson();
	}
	public void startDB(Map<Integer, Flight> flightTable) throws Exception{
		this.flightTable = flightTable;
		jsonManager.writeJsonJackson(flightTable.values());
	}
	
	public Collection<Flight> getFlights() {
		return flightTable.values();
	}
	
	public Flight getFlight(final Integer id) {
		return flightTable.get(id);
	}
	
	public void insertFlight(Flight flight) throws Exception {
		flight.setId(flightTable.size()+1);
		flightTable.put(flight.getId(), flight);
		jsonManager.writeJsonJackson(flightTable.values());
		
	}
	
	public void deleteFlight(Flight flight) throws Exception {
		flightTable.remove(flight.getId());
		jsonManager.writeJsonJackson(flightTable.values());
		
	}
	
	public void updateFlight(Flight flight) throws Exception {
		flightTable.put(flight.getId(), flight);
		jsonManager.writeJsonJackson(flightTable.values());
	}

	public Collection<Flight> getOrderFlights(String origin, String destin, Comparator<Flight> comparator) throws Exception {
		List<Flight> newList = new ArrayList<>(flightTable.values());
		List<Flight> searchedList = new SearcherOriginDestinFlight(origin, destin, newList).getSearchList();
		if(comparator!=null){
			Collections.sort(searchedList, comparator);
	    }	
		return searchedList;
	}

	public void saveFlights(Collection<Flight> flightCollection) throws Exception {
		jsonManager.writeJsonJackson(flightCollection);
	}
	
}
