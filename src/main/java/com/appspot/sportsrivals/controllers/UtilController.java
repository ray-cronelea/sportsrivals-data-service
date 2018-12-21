package com.appspot.sportsrivals.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UtilController {

	@GetMapping("/servertime")
	public String serverTime() {
		return "The time at the server is now " + new Date() + "\n";
	}
}
