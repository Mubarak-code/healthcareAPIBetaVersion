package com.example.demo.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.impl.PatientService;

@RestController
@RequestMapping("api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/createnewpatient")
	public ResponseEntity<?> createNewPatient(@Valid @RequestBody Patient patient){
			return new ResponseEntity<String>(patientService.createNewPatient(patient), HttpStatus.OK);
		
	}
	
	@PutMapping("/updatepatient/{patientNumber}")
	public ResponseEntity<String> updatePatientRecord ( @PathVariable ("patientNumber") Long patientNumber, @Valid @RequestBody Patient patient) {

			return new ResponseEntity<String>(patientService.updatePatient(patientNumber, patient), HttpStatus.OK);

	}
	
	@DeleteMapping("/deletepatient/{patientNumber}")
	public ResponseEntity<String> deletePatient(@PathVariable ("patientNumber") Long patientNumber){
		return new ResponseEntity<String>(patientService.deletePatient(patientNumber), HttpStatus.OK);
	}

}
