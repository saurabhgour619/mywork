/**
 * 
 */
package com.cg.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.dao.EmployeeDao;
import com.cg.pojo.Employee;

/**
 * @author sogour
 *
 */
public class EmployeeDaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> empList = dao.getAllDetails();
		assertNotNull(empList);
	}

}
