package com.learning;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

	@Value("${mymessage}")
	private String myMessage;

	@RequestMapping
	public String printMessage() {
		return myMessage;
	}

}
