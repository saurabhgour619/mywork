/*
 *
 * created by Sourabh Gour
 */
package com.cg.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.model.User;
import com.cg.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUsers(ModelAndView model) throws IOException {
		List<User> listUser = userService.getUsers();
		model.addObject("users", listUser);
		model.setViewName("list-users");
		return model;
	}

	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public ModelAndView showFormForAdd(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("user-form");
		return model;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return new ModelAndView("redirect://user/list");
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
		User theUser = userService.getUser(theId);
		theModel.addAttribute("user", theUser);
		return "user-form";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam("userId") int id) {
		userService.deleteUser(id);
		return new ModelAndView("redirect:/user/list");
	}
}
