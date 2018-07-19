package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer getCustomer(int theId);

	public void saveCustomer(Customer theCustomer);

	public void updateCustomer(Customer theCustomer);

	public void deleteCustomer(int theId);
}
