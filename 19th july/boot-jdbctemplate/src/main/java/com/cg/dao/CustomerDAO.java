package com.cg.dao;

import java.util.List;

import com.cg.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public Customer getCustomer(int theId);

	public void saveCustomer(Customer theCustomer);

	public void updateCustomer(Customer theCustomer);

	public void deleteCustomer(int theId);

}
