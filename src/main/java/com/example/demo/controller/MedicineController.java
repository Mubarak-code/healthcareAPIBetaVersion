package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Medicine;
import com.example.demo.service.impl.MedicineService;


@RestController
@RequestMapping("api/medicine")
public class MedicineController {
	
	
	@Autowired
	private MedicineService medicineService;
	
	@PostMapping("/createmedicine")
	public ResponseEntity<?> createMedicine(@Valid @RequestBody Medicine medicine){
		return new ResponseEntity<String>(medicineService.createNewMedicine(medicine), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletemedicine/{id}")
	public ResponseEntity<?> deleteMedicine(@PathVariable ("id") Long medicineId){
		return new ResponseEntity<String>(medicineService.deleteMedicine(medicineId), HttpStatus.OK);
		
	}

}
