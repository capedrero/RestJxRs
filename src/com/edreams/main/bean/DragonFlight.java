package com.edreams.main.bean;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
@XmlRootElement
public class DragonFlight {
	private DragonFlightBeanFields inBound;
	private DragonFlightBeanFields outBound;
	private Double price;
	private String currency;

	public DragonFlight() {
		super();
	}
	@JsonProperty("inbound")
	public DragonFlightBeanFields getInBound() {
		return inBound;
	}
	@JsonProperty("outbound")
	public DragonFlightBeanFields getOutBound() {
		return outBound;
	}
	@JsonProperty("price")
	public Double getPrice() {
		return price;
	}
	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}
	@Override
	public String toString() {
		return "DragonFlight [" + (inBound != null ? "inBound=" + inBound + ", " : "")
				+ (outBound != null ? "outBound=" + outBound + ", " : "")
				+ (price != null ? "price=" + price + ", " : "") + (currency != null ? "currency=" + currency : "")
				+ "]";
	}
	
}
