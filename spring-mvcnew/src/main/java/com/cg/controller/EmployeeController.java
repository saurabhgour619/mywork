package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Employee emp) {
		dao.save(emp);

		return new ModelAndView("redirect:/viewemp");

	}

	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		List<Employee> list = dao.getAllRecords();
		return new ModelAndView("viewemp", "list", list);
	}

	/*
	 * @RequestMapping(value="/editemp/{id}") public ModelAndView edit(@PathVariable
	 * int id){
	 * 
	 * dao.update(id); return new ModelAndView("empeditform","command",emp); }
	 */

	/*
	 * @RequestMapping(value="/editsave",method = RequestMethod.POST) public
	 * ModelAndView editsave(@ModelAttribute("emp") Employee emp){ dao.update(emp);
	 * return new ModelAndView("redirect:/viewemp"); }
	 */
}
