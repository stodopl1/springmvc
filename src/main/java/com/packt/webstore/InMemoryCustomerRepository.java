package com.packt.webstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

	List<Customer> customerList = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository(){
		Customer customer1 = new Customer();
		customer1.setFirstName("John");
		customer1.setLastName("Amberstein");
		customer1.setCustomerId(1);
		customer1.setAddress("Wroclaw, Pilsudskiego 44");
		customer1.setNumberOfOrdersMade(0);
		
		Customer customer2 = new Customer();
		customer2.setFirstName("Alice");
		customer2.setLastName("WildBoar");
		customer2.setCustomerId(2);
		customer2.setAddress("Wroclaw, Pilsudskiego 47");
		customer2.setNumberOfOrdersMade(2);
		
		Customer customer3 = new Customer();
		customer3.setFirstName("Kathy");
		customer3.setLastName("Miller");
		customer3.setCustomerId(3);
		customer3.setAddress("Wroclaw, Pilsudskiego 49");
		customer3.setNumberOfOrdersMade(7);
		
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerList;
	}

}
