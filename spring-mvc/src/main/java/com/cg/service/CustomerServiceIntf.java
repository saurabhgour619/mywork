package com.cg.service;

import com.cg.pojos.Customer;

public interface CustomerServiceIntf {
	Customer validateCustomer(String email, String password);
}
