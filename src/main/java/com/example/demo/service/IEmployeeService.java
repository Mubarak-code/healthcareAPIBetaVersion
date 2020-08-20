package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {
	
	
	public String createNewEmployee(Employee employye);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(Long id);
	public String deleteEmployee(Long id);
	

}
