package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestControllerWithoutEureka {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/fromOtherClientNoEureka")
	public String readFromOtherClient() {
		String host = "http://localhost:8080";
		String mapping = "/message";
		String uri = host+mapping;
		String msg = restTemplate.getForObject(uri, String.class).toString();
		System.out.println(msg);
		return msg;
	}

}
