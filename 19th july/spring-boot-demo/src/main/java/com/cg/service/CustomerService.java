package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);

	boolean addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);
}
