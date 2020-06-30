package com.rbbn.hibernate.example.crudapi.service;

import java.util.List;

import com.rbbn.hibernate.example.crudapi.model.Employee;

public interface EmployeeService {
	
    List<Employee> getEmployeeList();
	
	Employee getEmployee(int id);
	
	void save(Employee employee);
	
	void delete (int id);

}
