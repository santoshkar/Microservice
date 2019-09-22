package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaHttpCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHttpCallApplication.class, args);
	}

}
