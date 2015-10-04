package com.edreams.main.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Booking {
	private Integer bookingID;
	private Integer userID;
	private Integer flightID;

	public Booking() {
		super();
	}

	public Integer getBookingID() {
		return bookingID;
	}

	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getFlightID() {
		return flightID;
	}

	public void setFlightID(Integer flightID) {
		this.flightID = flightID;
	}

	@Override
	public String toString() {
		return "Booking [" + (bookingID != null ? "bookingID=" + bookingID + ", " : "")
				+ (userID != null ? "userID=" + userID + ", " : "") + (flightID != null ? "flightID=" + flightID : "")
				+ "]";
	}
	

}
