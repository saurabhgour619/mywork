package com.cg.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pojos.Customer;

@Repository
public class CustomerDao implements CustomerDaoIntf {

	@Autowired
	private SessionFactory sf;

	@Override
	public Customer validateCustomer(String email, String password) {
		String jpql = "select c from Customer c where c.email = :evalue and c.password = :pvalue";
		return sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("evalue", email)
				.setParameter("pvalue", password).getSingleResult();
	}

}
