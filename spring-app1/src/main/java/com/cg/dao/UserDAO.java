/*
 *
 * created by Sourabh Gour
 */
package com.cg.dao;

import java.util.List;

import com.cg.model.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

}
