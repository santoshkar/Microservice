package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestControllerWithEureka {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/fromOtherClientWithEureka")
	public String readFromOtherClient() {
		List<ServiceInstance> instances = discoveryClient.getInstances("FIRST EUREKA CLIENT");
		String host = instances.get(0).getUri().toString();
		String mapping = "/message";
		String uri = host + mapping;
		String msg = restTemplate.getForObject(uri, String.class).toString();
		return msg;
	}
}
