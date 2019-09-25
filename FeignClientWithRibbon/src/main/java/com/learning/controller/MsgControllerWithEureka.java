package com.learning.controller;

import com.learning.feign.EmployeeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MsgControllerWithEureka {

    @Autowired
    private EmployeeFeignClient employeeFeignClient;

	@GetMapping("/empservice/{id}")
	public Employee readEmpFromEmpFeignClient(@PathVariable("id") long empId) {
	
		Employee emp = employeeFeignClient.getEmployeeById(empId);
		return emp;
	}

    @GetMapping("/empservice")
    public List<Employee> readEmpFromEmpFeignClient() {

        List<Employee> emp = employeeFeignClient.getAllEmployee();
        return emp;
    }
}
