package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/Register")
	public String register() {
	    return "Register";
	}
	@GetMapping("/EditEmp")
	public String editEmp() {
	    return "EditEmp";
	}
	@GetMapping("/DeleteEmp")
	public String deletEmp() {
	    return "DeleteEmp";
	}
	
}
