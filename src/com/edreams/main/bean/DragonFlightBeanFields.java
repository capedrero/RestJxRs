package com.edreams.main.bean;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
@XmlRootElement
public class DragonFlightBeanFields {
	private String airline;
	private String airlineImage;
	private String arrivalDate;
	private String arrivalTime;
	private String departureDate;
	private String departureTime;
	private String destination;
	private String origin;

	public DragonFlightBeanFields() {
		super();
	}

	@JsonProperty("airline")
	public String getAirline() {
		return airline;
	}
	@JsonProperty("airlineImage")
	public String getAirlineImage() {
		return airlineImage;
	}
	@JsonProperty("arrivalDate")
	public String getArrivalDate() {
		return arrivalDate;
	}
	@JsonProperty("arrivalTime")
	public String getArrivalTime() {
		return arrivalTime;
	}
	@JsonProperty("departureDate")
	public String getDepartureDate() {
		return departureDate;
	}
	@JsonProperty("departureTime")
	public String getDepartureTime() {
		return departureTime;
	}
	@JsonProperty("destination")
	public String getDestination() {
		return destination;
	}
	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	@Override
	public String toString() {
		return "DragonFlightBeanFields [" + (airline != null ? "airline=" + airline + ", " : "")
				+ (airlineImage != null ? "airlineImage=" + airlineImage + ", " : "")
				+ (arrivalDate != null ? "arrivalDate=" + arrivalDate + ", " : "")
				+ (arrivalTime != null ? "arrivalTime=" + arrivalTime + ", " : "")
				+ (departureDate != null ? "departureDate=" + departureDate + ", " : "")
				+ (departureTime != null ? "departureTime=" + departureTime + ", " : "")
				+ (destination != null ? "destination=" + destination + ", " : "")
				+ (origin != null ? "origin=" + origin : "") + "]";
	}
	

}
