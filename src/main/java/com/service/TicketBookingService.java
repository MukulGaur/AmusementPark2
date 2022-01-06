package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Activity;
import com.entity.Customer;
import com.entity.TicketBooking;
import com.exception.TicketBookingNotFoundException;
import com.repository.TicketBookingRepository;
import com.service.Iface.TicketBookingServiceIface;

@Service
public class TicketBookingService implements TicketBookingServiceIface{
	
	private TicketBookingRepository ticketRepo;
	
	@Autowired
	public TicketBookingService(TicketBookingRepository ticketRepo) {
		super();
		this.ticketRepo = ticketRepo;
	}

//	Insert Ticket records into database
	@Override
	public TicketBooking insertTicketBooking(TicketBooking ticketBooking) {
		return ticketRepo.save(ticketBooking);
	}

	
	@Override
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking, int id) throws TicketBookingNotFoundException {
		TicketBooking existingTicketBooking = ticketRepo.findById(id).orElseThrow(() -> new TicketBookingNotFoundException("Not found"));
		
		existingTicketBooking.setBill(ticketBooking.getBill());
		
		ticketRepo.save(existingTicketBooking);
		return existingTicketBooking;
	}

	@Override
	public void deleteTicketBooking(int ticketId) throws TicketBookingNotFoundException {
		ticketRepo.findById(ticketId).orElseThrow(() -> new TicketBookingNotFoundException("Not found"));
		
		ticketRepo.deleteById(ticketId);
	}

//	@Override
//	public List<TicketBooking> viewAllTicketsCustomer(int customerId) {
//		return ticketRepo.viewAllTicketsCustomer(customerId);
//	}

//	@Override
//	public TicketBooking calculateBill(int customerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<TicketBooking> getActivitiesDatewise(String date) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Customer> viewCustomerListByActivityName(String activityName) {
//		activityName = activity.getActivityName();
//		
//		return null;
//	}
//
//	@Override
//	public List<Customer> viewCustomerListByDate(String date) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
