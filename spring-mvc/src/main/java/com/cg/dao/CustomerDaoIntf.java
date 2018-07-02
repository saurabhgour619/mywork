package com.cg.dao;

import com.cg.pojos.Customer;

public interface CustomerDaoIntf {
	Customer validateCustomer(String email, String password);
}
