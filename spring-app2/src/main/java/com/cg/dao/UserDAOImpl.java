/*
 *
 * created by Sourabh Gour
 */
package com.cg.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static String SELECT = "from User order";
	private static String DELETE = "delete from User where id=:userId";

	@Override
	public List<User> getUsers() {
		return sessionFactory.getCurrentSession().createQuery(SELECT, User.class).getResultList();
	}

	@Override
	public void saveUser(User theUser) {
		sessionFactory.getCurrentSession().saveOrUpdate(theUser);
	}

	@Override
	public User getUser(int theId) {
		return sessionFactory.getCurrentSession().get(User.class, theId);
	}

	@Override
	public void deleteUser(int theId) {
		sessionFactory.getCurrentSession().createQuery(DELETE).setParameter("userId", theId).executeUpdate();
	}
}
