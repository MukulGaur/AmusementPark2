package com.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TicketBooking {
	
	@Id
	@GeneratedValue
	private int ticketBookingId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Activity activity;
	
	private String dateTime;
	private float bill;
	public int getTicketBookingId() {
		return ticketBookingId;
	}
	public void setTicketBookingId(int ticketBookingId) {
		this.ticketBookingId = ticketBookingId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void String(String dateTime) {
		this.dateTime = dateTime;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "TicketBooking [ticketBookingId=" + ticketBookingId + ", dateTime=" + dateTime + ", bill=" + bill + "]";
	}
	
	

}
