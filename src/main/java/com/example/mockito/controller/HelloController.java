package com.example.mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello-mockito")
	public String getController() {
		return "Hello mockito";
	}
}
