package com.cg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;
import com.cg.entity.CustomerRowMapper;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_GET_ALL = "SELECT * from Customer";
	private final String SQL_INSERT_CUSTOMER = "INSERT INTO customer (id, firstName, lastName, email) values (?, ?, ?,?)";
	private final String SQL_UPDATE_CUSTOMER = "UPDATE customer SET firstname=?, lastname=?, email=? WHERE id=?";
	private final String SQL_DELETE_PERSON = "DELETE from Customer where id=?";

	@Override
	public List<Customer> getCustomers() {
		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.query(SQL_GET_ALL, rowMapper);
	}

	@Override
	public Customer getCustomer(int theId) {
		RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<Customer>(Customer.class);
		return jdbcTemplate.queryForObject(SQL_GET_ALL, rowMapper, theId);
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		jdbcTemplate.update(SQL_INSERT_CUSTOMER, theCustomer.getId(), theCustomer.getFirstName(),
				theCustomer.getLastName(), theCustomer.getEmail());

		// Fetch customer id
		String sql = "SELECT id FROM customer WHERE firstname = ? and lastname=? and email=?";
		int id = jdbcTemplate.queryForObject(sql, Integer.class, theCustomer.getFirstName(), theCustomer.getLastName(),
				theCustomer.getEmail());

		// Set customer id
		theCustomer.setId(id);
	}

	@Override
	public void updateCustomer(Customer theCustomer) {
		jdbcTemplate.update(SQL_UPDATE_CUSTOMER, theCustomer.getId(), theCustomer.getFirstName(),
				theCustomer.getLastName(), theCustomer.getEmail());
	}

	@Override
	public void deleteCustomer(int theId) {
		jdbcTemplate.update(SQL_DELETE_PERSON, theId);
	}
}