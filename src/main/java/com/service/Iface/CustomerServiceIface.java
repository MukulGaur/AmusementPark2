package com.service.Iface;

import java.util.List;

import com.entity.Customer;

public interface CustomerServiceIface {
	
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer, int id);
	public String deleteCustomer(Customer customer, int id);
	public List<Customer>viewCustomers();
	public Customer viewCustomer(int customerId);
	
//	Custom Queries
	public List<Customer> viewCustomerListByActivityName(String activityName);
	public List<Customer> viewCustomerListByDate(String date);

}
