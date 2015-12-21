package com.edreams.main.controller;

import java.util.Collection;

import com.edreams.main.bean.Booking;
import com.edreams.main.model.ModelBookingService;

public class ControllerBookingService {
	private ModelBookingService modelBookingService;

	public ControllerBookingService() {
		super();
		this.modelBookingService = new ModelBookingService();
	}
	public void startDB() throws Exception {		
		this.modelBookingService.startDB();
		
	}
	public Collection<Booking> getBookings() {
		return modelBookingService.getBookings();
	}

	public Booking getBooking(final Integer id) {
		return modelBookingService.getBooking(id);
	}

	public void deleteBooking(Booking booking) throws Exception {
		modelBookingService.deleteBooking(booking);
	}

	public void insertBooking(Booking booking) throws Exception {
		modelBookingService.insertBooking(booking);
	}

	public void updateBooking(Booking booking) throws Exception {
		modelBookingService.updateBooking(booking);
	}
	

}
