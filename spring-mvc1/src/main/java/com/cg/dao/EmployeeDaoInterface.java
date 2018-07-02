package com.cg.dao;

import java.util.List;

import com.cg.pojos.Employee;

public interface EmployeeDaoInterface
{
	public int save(Employee emp);
	public List<Employee> getAllRecords();
}
