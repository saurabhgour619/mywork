package com.cg.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cg.pojos.Customer;
import com.cg.service.CustomerServiceIntf;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceIntf service;

	@GetMapping("/login")
	private String showLoginForm(Customer c) {
		System.out.println("show login form " + c);
		return "customer/login";
	}

	@PostMapping("/login")
	private String processLoginForm(Customer c, HttpSession hs, RedirectAttributes flashMap, Model map) {
		System.out.println("process login form " + c);
		try {
			Customer c1 = service.validateCustomer(c.getEmail(), c.getPassword());
			// add validated Customer details to session scope
			hs.setAttribute("valid_customer", c1);
			flashMap.addFlashAttribute("mesg", "Admin Login Successful");
			return "redirect:/product/list";

		} catch (NoResultException e) {
			// invalid login
			map.addAttribute("mesg", "Invalid Login , pls retry");
		}
		return "customer/login";
	}

}