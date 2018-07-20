package com.cg.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.entity.Guest;

@Repository
public class GuestDAOImpl implements GuestDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_GUEST = "INSERT INTO guest(guestID, email, firstName, lastName, address, phone, password, createdDate, updatedDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void saveGuest(Guest guest) {
		Object[] params = { guest.getGuestID(), guest.getEmail(), guest.getFirstName(), guest.getLastName(),
				guest.getAddress(), guest.getPhone(), guest.getPassword(), guest.getCreatedDate(),
				guest.getUpdatedDate() };
		jdbcTemplate.update(SQL_INSERT_GUEST, params);

		// Fetch guest id
		String sql = "SELECT customerID FROM guest WHERE email=? and firstName=? and lastName=? and address=? and phone=? and password=? and createdDate=? and updatedDate=?";
		int id = jdbcTemplate.queryForObject(sql, Integer.class, params);

		// Set guest id
		guest.setGuestID(id);
	}
}