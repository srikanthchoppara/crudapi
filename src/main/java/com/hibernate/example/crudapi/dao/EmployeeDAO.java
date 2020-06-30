package com.hibernate.example.crudapi.dao;

import com.hibernate.example.crudapi.model.Employee;

import java.util.List;

public interface EmployeeDAO {
	
	List<Employee> getEmployeeList();
	
	Employee getEmployee(int id);
	
	void save(Employee employee);
	
	void delete (int id);

}
