package com.cg.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GuestRowMapper implements RowMapper<Guest> {
	@Override
	public Guest mapRow(ResultSet row, int rowNum) throws SQLException {
		Guest g = new Guest();

		g.setGuestID(row.getLong("guestId"));
		g.setEmail(row.getString("email"));
		g.setFirstName(row.getString("firstName"));
		g.setLastName(row.getString("lastName"));
		g.setPhone(row.getString("phone"));
		g.setPassword(row.getString("password"));
		g.setAddress(row.getString("address"));
		g.setCreatedDate(row.getDate("createdDate"));
		g.setUpdatedDate(row.getDate("createdDate"));
		return g;
	}
}