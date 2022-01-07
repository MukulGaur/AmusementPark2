package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{
	
//	@Id
	private int customerId;
	
//	@OneToMany
//	private List<TicketBooking> ticket;
	
	

//	public List<TicketBooking> getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(List<TicketBooking> ticket) {
//		this.ticket = ticket;
//	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + "]";
	}
	
	

}
