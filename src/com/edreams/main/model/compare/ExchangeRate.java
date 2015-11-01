package com.edreams.main.model.compare;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class ExchangeRate {

	private String currencyFrom;
	private String currencyTo;
	private Double rate;

	@JsonProperty("from")
	public String getCurrencyFrom() {
		return currencyFrom;
	}

	@JsonProperty("to")
	public String getCurrencyTo() {
		return currencyTo;
	}

	@JsonProperty("rate")
	public Double getRate() {
		return rate;
	}

}
