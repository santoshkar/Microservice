package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MsgControllerWithEureka {
	
	/*
	@Autowired
	private DiscoveryClient discoveryClient;
	*/
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/fromOtherClientWithEureka")
	public String readFromOtherClient() {
		/*
		List<ServiceInstance> instances = discoveryClient.getInstances("FIRST EUREKA CLIENT");
		String host = instances.get(0).getUri().toString();
		*/
		
		ServiceInstance instance = loadBalancerClient.choose("FIRST EUREKA CLIENT");
		String host = instance.getUri().toString();
		
		String mapping = "/message";
		String uri = host+mapping;
		String msg = restTemplate.getForObject(uri, String.class).toString();
		return msg;
	}
}
