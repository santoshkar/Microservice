package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.service.EmployeeService;

@RestController
public class RestControllerWithEureka {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/fromOtherClientWithEureka")
	public String readFromOtherClient() {
		return employeeService.readFromOtherClient();
	}
	
	@GetMapping("/empservice/{id}")
	public Employee readEmpFromEmpMicroService(@PathVariable("id") long empId) {
		return employeeService.readEmpFromEmpMicroService(empId);
	}
	
	@GetMapping("/empservice")
    public List<Employee> findEmployees() {
        List<Employee> emp = employeeService.readEmpFromEmpMicroService();
        return emp;
    }
}
