package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.Employee;
import com.learning.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		
		Employee emp = empService.findEmployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.FOUND);
	}

	@GetMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {

		Employee emp = empService.findEmployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.FOUND);
	}
	
	@GetMapping(path = "/employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = empService.findAllEmployees();
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}
	
	@PostMapping(path = "/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee newEmployee = empService.createNewEmployee(emp);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
		Employee updatedEmployee = empService.updateEmployee(id,  emp);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}



