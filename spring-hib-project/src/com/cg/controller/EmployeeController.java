package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.dao.EmployeeDao;
import com.cg.pojos.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao dao;

	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform");
	}

	@RequestMapping("/viewemp")
	public ModelAndView viewEmp() {
		List<Employee> list = dao.getAllEmployees();
		return new ModelAndView("viewemp", "list", list);
	}
	
	@RequestMapping("/addemp")
	public ModelAndView addEmp(Employee e) {
		dao.addEmployee(e);
		return new ModelAndView("success");
	}
	
	@RequestMapping("/added")
	public ModelAndView add(Employee e) {
		dao.addEmployee(e);
		return new ModelAndView("success");
	}
}