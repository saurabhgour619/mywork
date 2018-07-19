package com.cg.dao;

import java.util.List;

import com.cg.entity.Customer;

public interface CustomerDAO {
	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);

	void addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);

	boolean customerExists(String firstName, String lastName, String email);
}
