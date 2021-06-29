package com.te.student_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SpringRestController {
	@GetMapping("/")
	public String testMethod() {
		return "Check Check";	
	}
}
