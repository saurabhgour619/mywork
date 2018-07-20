package com.cg.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Guest;
import com.cg.service.GuestService;

@RestController
@RequestMapping("/api")
public class GuestRestController {

	@Autowired
	private GuestService guestService;

	@PostMapping("/guests")
	public Guest createGuest(@RequestBody Guest guest) {
		guestService.createGuest(guest);
		return guest;
	}
}