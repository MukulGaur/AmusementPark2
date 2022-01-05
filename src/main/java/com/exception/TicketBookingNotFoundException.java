package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TicketBookingNotFoundException extends RuntimeException{
	
	private int ticketBookingId;
	
	public TicketBookingNotFoundException(int ticketBookingId) {
		super("No record found for the ticket booking ID: " + ticketBookingId);
		this.ticketBookingId = ticketBookingId;
	}
	
	public int getTicketBookingId() {
		return ticketBookingId;
	}

}
