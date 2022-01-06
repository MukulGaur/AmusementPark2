package com.service.Iface;

import java.util.List;

import com.entity.Customer;
import com.exception.CustomerNotFoundException;

public interface CustomerServiceIface {
	
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer, int id) throws CustomerNotFoundException;
	public String deleteCustomer(Customer customer, int id) throws CustomerNotFoundException;
	public List<Customer>viewCustomers();
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;

}
