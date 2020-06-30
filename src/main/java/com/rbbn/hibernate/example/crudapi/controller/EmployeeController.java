package com.rbbn.hibernate.example.crudapi.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.rbbn.hibernate.example.crudapi.dao.EmployeeSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbbn.hibernate.example.crudapi.model.Employee;
import com.rbbn.hibernate.example.crudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService  employeeService;

	@Autowired
	private EmployeeSearch empSearch;

	@GetMapping("/get")
	public List<Employee> get() {

		return employeeService.getEmployeeList();
	}

	@GetMapping("/search")
	public List<Employee> search() {
		List<Employee> searchResults = new ArrayList<Employee>();
		try {
			searchResults = empSearch.search();
		}
		catch (Exception ex) {
			// here you should handle unexpected errors
			// ...
			// throw ex;
			ex.printStackTrace();
		}
	    /*model.addAttribute("searchResults", searchResults);
	    return "search";
		try {
			searchResults.add(new Employee(2, "Vijay Doddegowda", "NMS", "male", new Date(System.currentTimeMillis())));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return searchResults;
	}

}
