package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Customer;
import com.entity.TicketBooking;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer>{
	
//	@Query("Select a from TicketBooking a where a.customerId=:customerId")
//	public List<TicketBooking> viewAllTicketsCustomer(int customerId);
	
//	@Query("Select a from TicketBooking a where a.date=:date")
//	public List<TicketBooking>getActivitiesDatewise(String date);
	
//	@Query("Select a from TicketBooking a where a.activityName=:activityName")
//	public List<TicketBooking>viewCustomerListByActivityName(String activityName);
	
//	@Query("")
//	public List<Customer> viewCustomerListByDate(String date);

}
