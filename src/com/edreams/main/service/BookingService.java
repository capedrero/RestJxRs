package com.edreams.main.service;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.edreams.main.bean.Booking;
import com.edreams.main.bean.Flight;
import com.edreams.main.bean.User;
import com.edreams.main.controller.ControllerBookingService;

@Path("/bookingService/")
public class BookingService {

	private ControllerBookingService controllerBookingService;

	public BookingService() throws Exception {
		super();
		this.controllerBookingService = new ControllerBookingService();

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
	public Response insertBooking(User user, Flight flight) throws Exception {

		Booking booking = new Booking();
		booking.setFlightID(flight.getId());
		booking.setUserID(user.getId());
		controllerBookingService.insertBooking(booking);
		String result = "Booking saved : " + booking;
		return Response.status(201).entity(result).build();

	}
	
	
	
	
	
	
	
	
	
	
	
}
