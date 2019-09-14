package com.learning;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Value("${common-message}")
	private String commonMsg;
	
	@Value("${system.env.msg}")
	private String envMsg;
	
	@GetMapping
	private String msg() {
		return "Add path to URL for config msg";
	}
	
	@GetMapping(path = "/common-msg")
	private String commonMsg() {
		return commonMsg;
	}
	
	@GetMapping(path = "/env-msg")
	private String envMsg() {
		return envMsg;
	}
}
