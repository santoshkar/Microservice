package com.learning.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.DiscoveryClient;

@Configuration
public class Config {
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
