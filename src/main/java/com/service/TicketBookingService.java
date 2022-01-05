package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.TicketBooking;
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
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking, int id) {
		TicketBooking existingTicketBooking = ticketRepo.findById(id).orElseThrow();
		
		existingTicketBooking.setBill(ticketBooking.getBill());
		
		ticketRepo.save(existingTicketBooking);
		return existingTicketBooking;
	}

	@Override
	public void deleteTicketBooking(int ticketId) {
		ticketRepo.findById(ticketId).orElseThrow();
		
		ticketRepo.deleteById(ticketId);
	}

	@Override
	public List<TicketBooking> viewAllTicketsCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketBooking calculateBill(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
