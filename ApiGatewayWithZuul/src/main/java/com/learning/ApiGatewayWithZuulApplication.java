package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.learning.proxy.PostFilter;
import com.learning.proxy.PreFilter;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayWithZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayWithZuulApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

}
