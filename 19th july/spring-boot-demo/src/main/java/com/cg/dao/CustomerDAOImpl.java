package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Customer;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		String hql = "FROM Customer as c ORDER BY c.customerId";
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer c = getCustomerById(customer.getId());
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());
		entityManager.flush();
	}

	@Override
	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));
	}

	@Override
	public boolean customerExists(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		return false;
	}
}
