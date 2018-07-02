package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.CustomerDaoIntf;
import com.cg.pojos.Customer;

@Service
@Transactional
public class CustomerService implements CustomerServiceIntf {
	@Autowired
	private CustomerDaoIntf dao;

	@Override
	public Customer validateCustomer(String email, String password) {
		return dao.validateCustomer(email, password);
	}

}
