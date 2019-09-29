package com.learning.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
public class EmployeeRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Employee emp = new Employee();
		emp.setId(rs.getLong("id"));
		emp.setName(rs.getString("name"));
		emp.setEmail(rs.getString("email"));
		emp.setDeptId(rs.getLong("dept_id"));
		
		return emp;
		
	}

}
