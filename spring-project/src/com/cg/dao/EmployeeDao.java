package com.cg.dao;

import java.util.List;

import com.cg.pojos.Employee;

public interface EmployeeDao
{
	public int save(Employee emp);
	public List<Employee> getAllRecords();
}
