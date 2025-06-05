package com.test.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/views/**")
	public void goPage() {
		
	}
}
