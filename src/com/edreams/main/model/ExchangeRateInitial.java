package com.edreams.main.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.edreams.main.model.compare.ExchangeRate;

@XmlRootElement
public class ExchangeRateInitial {

	private ExchangeRate obj;
	
	@JsonProperty("jarvis")
	public ExchangeRate getObj() {
		return obj;
	}
	
}
