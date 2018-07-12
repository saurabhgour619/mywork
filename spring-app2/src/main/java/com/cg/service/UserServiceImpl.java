/*
 *
 * created by Sourabh Gour
 */

package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.UserDAO;
import com.cg.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public void saveUser(User theUser) {
		userDAO.saveUser(theUser);
	}

	@Override
	public User getUser(int theId) {
		return userDAO.getUser(theId);
	}

	@Override
	public void deleteUser(int theId) {
		userDAO.deleteUser(theId);
	}
}
