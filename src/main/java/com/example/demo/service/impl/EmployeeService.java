package com.example.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;
import com.example.demo.validation.CustomValidator;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CustomValidator customValidator;

	@Override
	public String createNewEmployee(Employee employye) {
		//validate constraint
		customValidator.validateEntity(employye);
		employeeRepository.save(employye);
		
		return "Employee information saved";
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(Long id) {
		
		return employeeRepository.findById(id).get();
	}

	@Override
	public String deleteEmployee(Long id) {
		
		employeeRepository.deleteById(id);
		
		return "operation succcsful";
	}


}
