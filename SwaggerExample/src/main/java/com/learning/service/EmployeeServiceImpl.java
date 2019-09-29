package com.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dao.EmployeeRepository;
import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	private EmployeeRepository empRepository;
	
	@Override
	public Employee findEmployeeById(long id) {
		Optional<Employee> opt = empRepository.findById(id);
		
		if(opt.isPresent())
			return opt.get();
		else
			return null;
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		return empRepository.findAll();
	}

	@Override
	public Employee createNewEmployee(Employee emp) {
		return empRepository.save(emp);

	}

	@Override
	public Employee updateEmployee(long id, Employee emp) {
		Employee dbEmp = empRepository.getOne(id);
		dbEmp.setName(emp.getName());
		dbEmp.setEmail(emp.getEmail());
		dbEmp.setDeptId(emp.getDeptId());
		return empRepository.save(dbEmp);
	}

	@Override
	public void deleteEmployee(long id) {
		Employee dbEmp = empRepository.getOne(id);
		empRepository.delete(dbEmp);
		
	}
}
