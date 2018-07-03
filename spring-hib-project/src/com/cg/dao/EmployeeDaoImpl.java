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
	public List<Employee> getAllEmployees() {
		return sf.getCurrentSession().createQuery("from Employee", Employee.class).getResultList();

	}

	public void addEmployee(Employee employee) {
		sf.getCurrentSession().saveOrUpdate(employee);

	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee employee = (Employee) sf.getCurrentSession().load(Employee.class, id);
		if (null != employee) {
			this.sf.getCurrentSession().delete(employee);
		}

	}

	public Employee getEmployee(int id) {
		return (Employee) sf.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sf.getCurrentSession().update(employee);
		return employee;
	}
}
