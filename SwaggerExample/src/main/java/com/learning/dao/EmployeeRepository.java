package com.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
