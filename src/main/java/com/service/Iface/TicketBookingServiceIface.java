package com.service.Iface;

import java.util.List;

import com.entity.TicketBooking;

public interface TicketBookingServiceIface {
	
	public TicketBooking insertTicketBooking(TicketBooking ticketBooking);
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking, int id);
	public void deleteTicketBooking(int ticketId);
	
//	Custom Queries
	public List<TicketBooking> viewAllTicketsCustomer(int customerId);
	public TicketBooking calculateBill(int customerId);

}
