package com.edreams.main.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
@XmlRootElement
@JsonPropertyOrder({ "id", "origin", "destination", "dateArrival", "dateDeparture","price","currency","typeOffer" })
public class Flight {
	private Integer id;
	private String origin;
	private String destination;
	private Date dateArrival;
	private Date dateDeparture;
	private Double price;
	private String currency;
	private String typeOffer = TYPE_FLIGHT_OFFER.REGULAR_FLIGHT;

	private Date dateTripTimeDifference; 
	//TODO exchange
	//private ExchangePriceBean calculateExchangePrice; 
	
	
	public Flight() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
/*	public void setDateTripTimeDifference(Date dateTripTimeDifference) {
		this.dateTripTimeDifference = dateTripTimeDifference;
	}*/
	

	/*public void setCalculateExchangePrice(ExchangePriceBean calculateExchangePrice) {
		this.calculateExchangePrice = calculateExchangePrice;
	}
*/
	public Integer getId() {
		return id;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public Date getDateArrival() {
		return dateArrival;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}

	public Double getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	public String getTypeOffer() {
		return typeOffer;
	}

	@Override
	public String toString() {
		return "Flight [" + (id != null ? "id=" + id + ", " : "") + (origin != null ? "origin=" + origin + ", " : "")
				+ (destination != null ? "destination=" + destination + ", " : "")
				+ (dateArrival != null ? "dateArrival=" + dateArrival + ", " : "")
				+ (dateDeparture != null ? "dateDeparture=" + dateDeparture + ", " : "")
				+ (price != null ? "price=" + price + ", " : "")
				+ (currency != null ? "currency=" + currency + ", " : "")
				+ (typeOffer != null ? "typeOffer=" + typeOffer + ", " : "")
				+ (dateTripTimeDifference != null ? "dateTripTimeDifference=" + dateTripTimeDifference : "") + "]";
	}



	/*public Date getDateTripTimeDifference() {
		return dateTripTimeDifference;
	}*/


	


	
	
	
	
}
