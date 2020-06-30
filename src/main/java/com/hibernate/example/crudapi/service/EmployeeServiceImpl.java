package com.hibernate.example.crudapi.service;

import com.hibernate.example.crudapi.dao.EmployeeDAO;
import com.hibernate.example.crudapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Transactional
	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeList();
	}

	@Transactional
	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
