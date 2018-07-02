package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pojos.Employee;

@Repository
public class EmployeeDao implements EmployeeDaoInterface{
	
	@Autowired
	private SessionFactory sf;

	@Override
	public int save(Employee emp) {
		return 0;
	}
 
	@Override
	public List<Employee> getAllRecords() {
		String query="select e from Employee";
		sf.openSession();
		EntityManager em = sf.createEntityManager();
		Query query1 = em.createQuery(query);
		List<Employee> list = query1.getResultList();
		return list;
	}
}
