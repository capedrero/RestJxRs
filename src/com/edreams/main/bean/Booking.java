package com.edreams.main.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Booking {
	private Integer bookingID;
	private User user;
	private Flight flight;

	public Booking() {
		super();
	}

	

	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}



	public Integer getBookingID() {
		return bookingID;
	}



	public User getUser() {
		return user;
	}



	public Flight getFlight() {
		return flight;
	}

 

	public void setUser(User user) {
		this.user = user;
	}



	public void setFlight(Flight flight) {
		this.flight = flight;
	}



	@Override
	public String toString() {
		return "Booking [" + (bookingID != null ? "bookingID=" + bookingID + ", " : "")
				+ (user != null ? "user=" + user + ", " : "") + (flight != null ? "flight=" + flight : "") + "]";
	}
	
	




}
