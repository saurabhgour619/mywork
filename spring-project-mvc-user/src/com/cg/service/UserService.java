/*
 *
 * created by Sourabh Gour
 */

package com.cg.service;

import java.util.List;

import com.cg.pojos.User;

public interface UserService {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

}
