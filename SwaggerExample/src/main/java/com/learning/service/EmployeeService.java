package com.learning.service;

import java.util.List;

import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
public interface EmployeeService {

	Employee findEmployeeById(long id);
	List<Employee> findAllEmployees();
	Employee createNewEmployee(Employee emp);
	void deleteEmployee(long id);
	Employee updateEmployee(long id, Employee emp);


}
