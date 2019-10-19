package com.learning.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.controller.Employee;


//This is the Client Micro-service we are going to communicate with
@FeignClient(name="FIRSTEUREKACLIENT")
public interface EmployeeFeignClient {

	@GetMapping("/employee/{id}")
	Employee getEmployeeById(@PathVariable("id") long empId);
	
	@GetMapping("/employee")
	List<Employee> getAllEmployee();


}
