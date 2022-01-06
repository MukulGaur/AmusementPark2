package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Customer;
import com.repository.CustomerRepository;

class CustomerServiceTest {

	@Autowired
	CustomerService customerservice;

	@MockBean
	CustomerRepository customerRepo;

	@Test
	void testInsertCustomer() {
		Customer c1=new Customer();
		c1.setCustomerId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirsrtName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		Mockito.when(customerRepo.save(c1)).thenReturn(c1);

		assertThat(customerservice.insertCustomer(c1)).isEqualTo(c1);
	}


	@Test
	void testUpdateCustomer()throws Throwable {
		Customer c1=new Customer();
		c1.setCustomerId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirsrtName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		Optional<Customer> c2=Optional.of(c1);

		Mockito.when(customerRepo.findById(1)).thenReturn(c2);

		Mockito.when(customerRepo.save(c1)).thenReturn(c1);
		c1.setFirsrtName("Madhulika");
		c1.setLastName("L");

		assertThat(customerservice.updateCustomer(c1, 1)).isEqualTo(c1);
	}

	@Test
	void testDeleteCustomer() {
		Customer c1=new Customer();
		c1.setCustomerId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirsrtName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		Optional<Customer> c2=Optional.of(c1);

		Mockito.when(customerRepo.findById(1)).thenReturn(c2);
		Mockito.when(customerRepo.existsById(c1.getCustomerId())).thenReturn(false);
		assertFalse(customerRepo.existsById(c1.getCustomerId()));
	}

	@Test
	void testDeleteCustomerById()throws Throwable {
		Customer c1=new Customer();
		c1.setCustomerId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirsrtName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		Optional<Customer> c2=Optional.of(c1);

		Mockito.when(customerRepo.findById(1)).thenReturn(c2);
		Mockito.when(customerRepo.existsById(c1.getCustomerId())).thenReturn(false);
		assertFalse(customerRepo.existsById(c1.getCustomerId()));
	}


	@Test
	void testViewCustomers() {
		Customer c1=new Customer();
		c1.setCustomerId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirsrtName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");

		Customer c2=new Customer();
		c2.setCustomerId(2);
		c2.setEmail("customer2@gmail.com");
		c2.setFirsrtName("SP Bala");
		c2.setLastName("Subramanyam");
		c2.setMobileNumber("9988332514");
		c2.setPassword("Bala@12");
		c2.setUsername("SPBala");

		List<Customer> customerList = new ArrayList<>();
		customerList.add(c1);
		customerList.add(c2);

		Mockito.when(customerRepo.findAll()).thenReturn(customerList);

		assertThat(customerservice.viewCustomers()).isEqualTo(customerList);
	}


@Test
void testViewCustomerById() throws Throwable {
	
	  Customer c3=new Customer(); 
	  c3.setCustomerId(1);
		c3.setEmail("customer@gmail.com");
		c3.setFirsrtName("Geetha");
		c3.setLastName("Madhuri");
		c3.setMobileNumber("9988445512");
		c3.setPassword("Geeth@12");
		c3.setUsername("Geetmadhu");
	 
	Optional<Customer> c2=Optional.of(c3);
	
	Mockito.when(customerRepo.findById(1)).thenReturn(c2);
	
	assertThat(customerservice.viewCustomer(1)).isEqualTo(c3);
}

@Test
void testViewCustomerListByDate() {
	fail("Not yet implemented");
}

}
