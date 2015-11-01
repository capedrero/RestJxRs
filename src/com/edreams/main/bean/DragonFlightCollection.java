package com.edreams.main.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class DragonFlightCollection {

	private List<DragonFlight> listDragonFlights;

	public DragonFlightCollection() {
		super();
	}


	@JsonProperty("results")
	public List<DragonFlight> getListDragonFlights() {
		return listDragonFlights;
	}

	
	

}
