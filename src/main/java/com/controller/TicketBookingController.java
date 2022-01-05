package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.TicketBooking;
import com.service.TicketBookingService;

@RestController
@RequestMapping(path="/api")
public class TicketBookingController {
	
	private TicketBookingService ticketBookingService;

	@Autowired
	public TicketBookingController(TicketBookingService ticketBookingService) {
		super();
		this.ticketBookingService = ticketBookingService;
	}
	
//	Insert ticket details
	@PostMapping("/insertTicket")
	public ResponseEntity<TicketBooking> insertTicketBooking(@RequestBody TicketBooking ticket){
		return new ResponseEntity<TicketBooking>(ticketBookingService.insertTicketBooking(ticket), HttpStatus.CREATED);
	}
	
//	Update ticket details
	@PutMapping("/updateTicketDetails/{ticketId}")
	public ResponseEntity<TicketBooking> updateTicketBooking(@RequestBody TicketBooking ticket, @PathVariable int ticketId){
		return new ResponseEntity<TicketBooking>(ticketBookingService.updateTicketBooking(ticket, ticketId), HttpStatus.OK);
	}
	
//	Delete ticket details
	@DeleteMapping("/deleteTicketDetails/{ticketId}")
	public ResponseEntity<String> deleteTicketBooking(@PathVariable int ticketId){
		ticketBookingService.deleteTicketBooking(ticketId);
		return new ResponseEntity<String>("Ticket record deleted !", HttpStatus.OK);
	}
	
//	public List<TicketBooking> viewAllTicketsCustomer(int customerId);
//	public TicketBooking calculateBill(int customerId);

}
