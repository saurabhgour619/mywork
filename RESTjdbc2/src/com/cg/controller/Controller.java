package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.EmployeeDao;
import com.cg.pojo.Employee;

@RestController
@RequestMapping("/product")
public class Controller {

	@Autowired
	private EmployeeDao edao;
	
	@RequestMapping(value="/getjson", method=RequestMethod.GET)
	public ResponseEntity<?> get() throws Exception{
		List<Employee> e=edao.getAllDetails();
		return new ResponseEntity<Employee>((Employee) e,HttpStatus.OK);
		
	}
	
}