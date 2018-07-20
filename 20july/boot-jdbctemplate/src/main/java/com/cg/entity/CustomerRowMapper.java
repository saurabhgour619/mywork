package com.cg.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet row, int rowNum) throws SQLException {
		Customer c = new Customer();
		c.setId(row.getInt("id"));
		c.setFirstName(row.getString("firstName"));
		c.setLastName(row.getString("lastName"));
		c.setEmail(row.getString("email"));
		return c;
	}
}