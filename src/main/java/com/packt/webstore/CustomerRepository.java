package com.packt.webstore;

import java.util.List;

import com.packt.webstore.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
