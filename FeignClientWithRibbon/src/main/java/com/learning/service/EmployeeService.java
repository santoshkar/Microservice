package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.controller.Employee;
import com.learning.feign.EmployeeFeignClient;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeFeignClient employeeFeignClient;

    public Employee readEmpFromEmpFeignClient(@PathVariable("id") long empId) {

	    /*
	    This is how we can communicate with another micro-service
	     */
        Employee emp = employeeFeignClient.getEmployeeById(empId);
        return emp;
    }

    public List<Employee> readEmpFromEmpFeignClient() {

        List<Employee> emp = employeeFeignClient.getAllEmployee();
        return emp;
    }

}
