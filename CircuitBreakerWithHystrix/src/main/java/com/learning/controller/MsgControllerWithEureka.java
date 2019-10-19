package com.learning.controller;

import com.learning.feign.EmployeeFeignClient;
import com.learning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MsgControllerWithEureka {

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
