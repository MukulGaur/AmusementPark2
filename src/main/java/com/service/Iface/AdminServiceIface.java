package com.service.Iface;

import java.util.List;

import com.entity.Admin;
import com.entity.TicketBooking;

public interface AdminServiceIface {
	
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin, int id);
	public String deleteAdmin(int adminId);
	public List<Admin> viewAdmins();
//	public List<TicketBooking>getAllActivities(int customerId);
//	public List<TicketBooking>getAllActivities();
//	public List<TicketBooking>getActivitiesCustomerwise();
//	public List<TicketBooking>getActivitiesDatewise();
//	public List<TicketBooking>getAllActivitiesForDays(int customerId, String fromDate, String toDate);

}
