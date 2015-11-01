package com.edreams.main.dao;

import java.util.ArrayList;
import java.util.List;

import com.edreams.main.bean.Flight;

public class SearcherOriginDestinFlight implements ISearchFlight{
	private String origin;
	private String destin;
	private List<Flight> list;
	
	public SearcherOriginDestinFlight(String origin, String destin, List<Flight> list) {
		super();
		this.origin = origin;
		this.destin = destin;
		this.list = list;
	}

	public List<Flight> getSearchList() {
		List<Flight> newList = new ArrayList<>();
		if(origin==null && destin==null){
			return list;
		}
		if(origin!=null){
		for (Flight flight : list) {
			if(origin.equals(flight.getOrigin())){
				newList.add(flight);
			}
		}
		}
		if(destin!=null){
			for (Flight flight : list) {
				if(origin.equals(flight.getDestination())){
					newList.add(flight);
				}
			}
		}
		return newList;
	}

	

}
