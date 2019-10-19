package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.controller.Employee;
import com.learning.feign.EmployeeFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeFeignClient employeeFeignClient;

    @HystrixCommand(fallbackMethod = "employeeServiceFailure_Fallback")
    public Employee readEmpFromEmpFeignClient(@PathVariable("id") long empId) {

	    /*
	    This is how we can communicate with another micro-service
	     */
        return employeeFeignClient.getEmployeeById(empId);
    }

    //@HystrixCommand(fallbackMethod = "employeeServiceFailure_Fallback")
    public List<Employee> readEmpFromEmpFeignClient() {
        return employeeFeignClient.getAllEmployee();
    }

    @SuppressWarnings("unused")
	private Employee employeeServiceFailure_Fallback(long empId) {

        System.out.println("Employee Service is down!!! fallback route enabled...");
        return new Employee();


    }

}
