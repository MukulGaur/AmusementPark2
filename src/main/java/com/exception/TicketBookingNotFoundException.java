package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TicketBookingNotFoundException extends Exception{

	public TicketBookingNotFoundException(String message) {
		super(message);
	}

}