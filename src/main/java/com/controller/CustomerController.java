package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping(path="/api")
public class CustomerController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
//	Insert customer record
	@PostMapping("/insertCustomer")
	public ResponseEntity<Customer> saveStudent(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.insertCustomer(customer), HttpStatus.CREATED);
	}
	
//	Update customer record
	@PutMapping("updateCustomer")
	public  ResponseEntity<Customer> updateStudent(@RequestBody Customer customer, @PathVariable int customerIdd){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, customerIdd), HttpStatus.OK);
	}
	
//	Delete customer record
	@DeleteMapping("/deleteCustomerById/{customerId}")
	public ResponseEntity<String> deleteStudent(@RequestBody Customer customer , @PathVariable int customerId){
			
			customerService.deleteCustomer(customer, customerId);
			
			return new ResponseEntity<String>("Customer record deleted succussfully !", HttpStatus.OK);
	}
	
//	Get all customers
	@GetMapping("/viewCustomers")
	public List<Customer> viewAllCustomers(){
		return customerService.viewCustomers();
	}
	
//	Get customer by Id
	@GetMapping("/viewCustomerById/{customerId}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable int customerId){
		return new ResponseEntity<Customer>(customerService.viewCustomer(customerId), HttpStatus.OK);
	}
	
//	public List<Customer> viewCustomeListByActivity(){
//		
//	}
//	
//	public List<Customer> viewCustomeListByDate(){
//		
//	}

}
