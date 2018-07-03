package com.cg.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pojos.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public int save(Employee emp) {
		return 0;
	}

	@Override
	public List<Employee> getAllRecords() {
		String query = "from Employee";
		return sf.getCurrentSession().createQuery(query, Employee.class).getResultList();

	}
}
