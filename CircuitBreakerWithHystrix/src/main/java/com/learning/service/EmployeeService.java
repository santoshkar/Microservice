package com.learning.service;

import com.learning.controller.Employee;
import com.learning.feign.EmployeeFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeFeignClient employeeFeignClient;

    @HystrixCommand(fallbackMethod = "employeeServiceFailure_Fallback")
    public Employee readEmpFromEmpFeignClient(@PathVariable("id") long empId) {

	    /*
	    This is how we can communicate with another micro-service
	     */
        Employee emp = employeeFeignClient.getEmployeeById(empId);
        return emp;
    }

    //@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
    public List<Employee> readEmpFromEmpFeignClient() {

        List<Employee> emp = employeeFeignClient.getAllEmployee();
        return emp;
    }

    private Employee employeeServiceFailure_Fallback(long empId) {

        System.out.println("Employee Service is down!!! fallback route enabled...");
        return new Employee();


    }

}
