package com.edreams.main.model;

import java.util.Collection;

import com.edreams.main.bean.Booking;
import com.edreams.main.dao.ManagerBookingDao;

public class ModelBookingService {
	private ManagerBookingDao dao;
	
	public ModelBookingService() {
		super();
		this.dao = new ManagerBookingDao();		
	}

	public Booking getBooking(final Integer id) {
		return dao.getBooking(id);
	}

	public Collection<Booking> getBookings() {
		return dao.getBookings();
	}

	public void deleteBooking(Booking booking) throws Exception {
		dao.deleteBooking(booking);
	}

	public void insertBooking(Booking booking) throws Exception {
		dao.insertBooking(booking);
	}

	public void updateBooking(Booking booking) throws Exception {
		dao.updateBooking(booking);
	}
	
}
