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

	@GetMapping("/empservice/{id}")
	public Employee findEmployeeById(@PathVariable("id") long empId) {

	    /*
	    This is how we can communicate with another micro-service
	     */
		Employee emp = employeeService.readEmpFromEmpFeignClient(empId);
		return emp;
	}

    @GetMapping("/empservice")
    public List<Employee> findEmployees() {

        List<Employee> emp = employeeService.readEmpFromEmpFeignClient();
        return emp;
    }
}
