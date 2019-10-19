package com.learning.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.controller.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

    public String readFromOtherClient() {
		ServiceInstance instance = loadBalancerClient.choose("FIRSTEUREKACLIENT");
		String host = instance.getUri().toString();
		String mapping = "/message";
		String uri = host+mapping;
		String msg = restTemplate.getForObject(uri, String.class).toString();
		return msg;
	}
    
	public Employee readEmpFromEmpMicroService(long empId) {
	
		ServiceInstance instance = loadBalancerClient.choose("FIRSTEUREKACLIENT");
		String host = instance.getUri().toString();
		String mapping = "/employee/{0}";
		String uri = host+mapping;
		ResponseEntity<Employee> empEntity = restTemplate.getForEntity(uri, Employee.class, empId);
		return empEntity.getBody();
	}
    
   	public List<Employee> readEmpFromEmpMicroService() {
   	
   		ServiceInstance instance = loadBalancerClient.choose("FIRSTEUREKACLIENT");
   		String host = instance.getUri().toString();
   		String mapping = "/employee";
   		String uri = host+mapping;
   		ResponseEntity<Employee[]> empEntity = restTemplate.getForEntity(uri, Employee[].class);
   		return Arrays.asList(empEntity.getBody());
   	}
}
