package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Admin;
import com.entity.TicketBooking;
import com.repository.AdminRepository;
import com.service.Iface.AdminServiceIface;

@Service
public class AdminService implements AdminServiceIface{
	
	private AdminRepository adminRepo;
	
	@Autowired
	public AdminService(AdminRepository adminRepo) {
		super();
		this.adminRepo = adminRepo;
	}

//	Insert Admin record into database
	@Override
	public Admin insertAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

//	Update Admin record using ID
	@Override
	public Admin updateAdmin(Admin admin, int id) {
		Admin existingAdmin = adminRepo.findById(id).orElseThrow();
		
		existingAdmin.setFirsrtName(admin.getFirsrtName());
		existingAdmin.setLastName(admin.getLastName());
		existingAdmin.setUsername(admin.getUsername());
		existingAdmin.setPassword(admin.getPassword());
		existingAdmin.setMobileNumber(admin.getMobileNumber());
		existingAdmin.setEmail(admin.getEmail());
		
		adminRepo.save(existingAdmin);
		return existingAdmin;
	}

//	Delete Admin record using ID
	@Override
	public String deleteAdmin(int adminId) {
		adminRepo.findById(adminId).orElseThrow();
		adminRepo.deleteById(adminId);
		
		return "deleted";
	}

	@Override
	public List<Admin> viewAdmins() {
		return adminRepo.findAll();
	}

//	View all Activities for the given Customer ID
//	@Override
//	public List<TicketBooking> getAllActivities(int customerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	View all activities
//	@Override
//	public List<TicketBooking> getAllActivities() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	View all Activities Customer-wise
//	@Override
//	public List<TicketBooking> getActivitiesCustomerwise() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	View Activities date-wise
//	@Override
//	public List<TicketBooking> getActivitiesDatewise() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	View Activities for the given dates
//	@Override
//	public List<TicketBooking> getAllActivitiesForDays(int customerId, String fromDate, String toDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
