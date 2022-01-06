package com.service.Iface;

import java.util.List;

import com.entity.Admin;
import com.entity.TicketBooking;
import com.exception.AdminNotFoundException;

public interface AdminServiceIface {
	
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin, int id) throws AdminNotFoundException;
	public String deleteAdmin(int adminId) throws AdminNotFoundException;
	public List<Admin> viewAdmins();

}
