package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientWithRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientWithRibbonApplication.class, args);
	}

}
