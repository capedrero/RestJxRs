package com.edreams.main.service;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edreams.main.bean.Booking;
import com.edreams.main.controller.ControllerBookingService;

@Path("/bookingService/")
public class BookingService {

	private ControllerBookingService controllerBookingService;

	public BookingService() throws Exception {
		super();
		this.controllerBookingService = new ControllerBookingService();
		controllerBookingService.startDB();
	}

	@GET
	@Path("/getBookings")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Booking> getBookings() {
		return controllerBookingService.getBookings();
	}
	
	@POST
	@Path("/insertBooking")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Booking insertBooking(Booking booking) throws Exception {
		
		controllerBookingService.insertBooking(booking);
		String result = "Booking saved : " + booking;
		//return Response.status(201).entity(result).build();
		return booking;

	}
	
	
}
