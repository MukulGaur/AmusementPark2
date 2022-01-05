package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.repository.CustomerRepository;
import com.service.Iface.CustomerServiceIface;

@Service
public class CustomerService implements CustomerServiceIface{
	
	private CustomerRepository customerRepo;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

//	Insert Customer record into database
	@Override
	public Customer insertCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

//	Update Customer record using ID
	@Override
	public Customer updateCustomer(Customer customer, int id) {
		Customer existingCustomer = customerRepo.findById(id).orElseThrow();
		
		existingCustomer.setFirsrtName(customer.getFirsrtName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setMobileNumber(customer.getMobileNumber());
		existingCustomer.setEmail(customer.getEmail());
		
		customerRepo.save(existingCustomer);
		return existingCustomer;
	}

//	Delete Customer records using ID
	@Override
	public String deleteCustomer(Customer customer, int id) {
		customerRepo.findById(id).orElseThrow();
		customerRepo.deleteById(id);
		
		return "Deleted";
	}

//	View all Customer records
	@Override
	public List<Customer> viewCustomers() {
		return customerRepo.findAll();
	}

//	View all Customer records using ID
	@Override
	public Customer viewCustomer(int customerId) {
		return customerRepo.findById(customerId).orElseThrow();
	}

//	View Customer records using customer-name
	@Override
	public List<Customer> viewCustomerListByActivityName(String activityName) {
		// TODO Auto-generated method stub
		return null;
	}

//	View Customer records by dates
	@Override
	public List<Customer> viewCustomerListByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
