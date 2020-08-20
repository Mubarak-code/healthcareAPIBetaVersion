package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.impl.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/createnewemployee")
	public ResponseEntity<String> createNewEmployee(@Valid @RequestBody Employee employee){
		//return  ResponseEntity.ok("Input valid and saved");
		return new ResponseEntity<String>(employeeService.createNewEmployee(employee), HttpStatus.OK);
	}
	
	@GetMapping("/getallemployees")
	public ResponseEntity<?> getAllEmployees(){
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable ("id") Long id){
		return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.OK );
	}
	
	
}