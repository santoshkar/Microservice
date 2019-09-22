package com.learning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping
	public String printMessage() {
		return "Hello Security World";
	}
}
