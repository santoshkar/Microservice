package com.learning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@RequestMapping("/message")
	public String message() {
		return "Hello, this is from client - 1";
	}
	
}
