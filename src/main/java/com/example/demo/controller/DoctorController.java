package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.model.Employee;
import com.example.demo.model.Patient;
import com.example.demo.service.impl.DoctorService;

@RestController
@RequestMapping("api/doctor")
public class DoctorController extends Employee {
	
	@Autowired
	private DoctorService doctorService;
	
	
	@PostMapping("/newdoctor")
	public ResponseEntity<String> newDoctor(@Valid @RequestBody Doctor doctor){
		return new ResponseEntity<String>(doctorService.newDoctor(doctor), HttpStatus.OK);
	}
	
	@PostMapping( "/givediagnostics")
	public ResponseEntity<String> givePatientDiagnostic(@Valid @PathParam(value = "message") String message, @PathParam(value = "doctorId")Long doctorId , @PathParam(value = "patientId")Long patientId){
		return new ResponseEntity<String>(doctorService.givePatientDiagnostic(message, doctorId, patientId), HttpStatus.OK);
	}
	
	
	
	@PostMapping("/prescribemedicine")
	public ResponseEntity<String> prescribeDrug(@Valid @PathParam(value = "medicineId") Long medicineId, @PathParam(value = "nurseId")Long nurseId, @PathParam(value = "doctorId") Long doctorId, @PathParam(value = "patientId") Long patientId){
		return new ResponseEntity<String>(doctorService.prescribeMedicine(medicineId, nurseId, doctorId, patientId), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/doctors/{pageNo}")
	public ResponseEntity<List<Doctor>> getdoctorList(@PathVariable (value ="pageNo") int pageNo, @RequestParam ("name") String name, @RequestParam ("sortDirection") String sortDirection){
		int pageSize = 2;
		Page<Doctor> page = doctorService.getallDoctors(pageNo, pageSize, name, sortDirection);
		List<Doctor> doctors = page.getContent();
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}



	@GetMapping("/getdoctorstartwith/{pageNo}/{word}")
	public ResponseEntity<List<Doctor>> getAllDoctorStartWith(@PathVariable ("pageNo") int pageNo,@PathVariable ("word") String word){
		return new ResponseEntity<List<Doctor>>(doctorService.getDoctorsStartingWith(pageNo,word).getContent(), HttpStatus.OK);
	}
	
	@GetMapping("/getdoctorpatients/{id}")
	public ResponseEntity<List<Patient>> getDoctorPatients(@PathVariable ("id") Long doctorId){
		return new ResponseEntity<List<Patient>>(doctorService.getAllPatient(doctorId), HttpStatus.OK);
	}
	 
}
