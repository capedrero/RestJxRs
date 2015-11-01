package com.edreams.main.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.edreams.main.model.compare.ExchangeRate;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ExchangeRateInitial {

	private ExchangeRate obj;
	
	@JsonProperty("jarvis")
	public ExchangeRate getObj() {
		return obj;
	}
	
}
