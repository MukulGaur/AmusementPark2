package com.service.Iface;

import java.util.List;

import com.entity.TicketBooking;
import com.exception.TicketBookingNotFoundException;

public interface TicketBookingServiceIface {
	
	public TicketBooking insertTicketBooking(TicketBooking ticketBooking);
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking, int id) throws TicketBookingNotFoundException;
	public void deleteTicketBooking(int ticketId) throws TicketBookingNotFoundException;
	
//	Custom Queries
//	public List<TicketBooking> viewAllTicketsCustomer(int customerId);
//	public TicketBooking calculateBill(int customerId);
//	public List<TicketBooking>getActivitiesDatewise(String date);
//	public List<Customer> viewCustomerListByActivityName(String activityName);
//	public List<Customer> viewCustomerListByDate(String date);

}
