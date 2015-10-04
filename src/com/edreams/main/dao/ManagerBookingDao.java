package com.edreams.main.dao;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.edreams.main.bean.Booking;
import com.edreams.main.dao.json.JsonBookingManager;

public class ManagerBookingDao {
	private Map<Integer, Booking> bookingTable;
	private JsonBookingManager jsonManager;

	public ManagerBookingDao() {
		jsonManager = new JsonBookingManager(new File(System.getProperty("user.home")+"\\Bookings.json"));
		bookingTable = new HashMap<>();
	}
	
	public void readDB() throws Exception{
		bookingTable = jsonManager.readJsonJackson();
	}
	public void startDB(Map<Integer, Booking> bookingTable) throws Exception{
		this.bookingTable = bookingTable;
		jsonManager.writeJsonJackson(bookingTable.values());
	}
	
	public Collection<Booking> getBookings() {
		return bookingTable.values();
	}
	
	public Booking getBooking(final Integer id) {
		return bookingTable.get(id);
	}
	
	public void insertBooking(Booking booking) throws Exception {
		booking.setBookingID(bookingTable.size()+1);
		bookingTable.put(booking.getBookingID(), booking);
		jsonManager.writeJsonJackson(bookingTable.values());
		
	}
	
	public void deleteBooking(Booking booking) throws Exception {
		bookingTable.remove(booking.getBookingID());
		jsonManager.writeJsonJackson(bookingTable.values());
		
	}
	
	public void updateBooking(Booking booking) throws Exception {
		bookingTable.put(booking.getBookingID(), booking);
		jsonManager.writeJsonJackson(bookingTable.values());
	}
}
