package com.learning.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Employee;

@RestController
public class MessageController {
	
	public Map<Long, Employee> empMap;
	
	@PostConstruct
	public void init() {
		empMap = new HashMap<Long, Employee>();
		empMap.put(1L, new Employee(1, "EmployeeOne"));
		empMap.put(2L, new Employee(2, "EmployeeTwo"));
		empMap.put(3L, new Employee(3, "EmployeeThree"));
	}

	@RequestMapping("/message")
	public String message() {
		return "Hello, this is from client - 1";
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return empMap.get(id);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(empMap.values());
	}
	
	@PreDestroy
	public void destroy() {
		empMap = null;
	}
	
}
