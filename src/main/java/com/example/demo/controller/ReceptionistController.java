package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Receptionist;
import com.example.demo.service.impl.ReceptionistService;

@RestController
@RequestMapping("api/receptionist")
public class ReceptionistController {
	
	@Autowired
	private ReceptionistService receptionistService;
	
	@PostMapping("/assignpatient")
	public ResponseEntity<String> assignPatienttoDoctor(@PathParam (value = "patientid") Long patientId, @PathParam (value = "doctorId") Long doctorId){
		return new ResponseEntity<String>(receptionistService.assignPatienttoDoctor(patientId, doctorId), HttpStatus.OK);
	}
	
	@PostMapping("/createnewreceptionist")
	public ResponseEntity<String> newReceptionist(@Valid @RequestBody Receptionist receptionist) {
		return new ResponseEntity<String>(receptionistService.newReceptionist(receptionist), HttpStatus.OK);
	}
	
	@GetMapping("/getallreceptionist")
	public ResponseEntity<List<Receptionist>> getReceptionists(){
		return new ResponseEntity<List<Receptionist>>(receptionistService.getAllReceptionist(), HttpStatus.OK);
	}
	
	@PostMapping("/assignnurse")
	public ResponseEntity<String> assignNursetoDoctor(@Valid @PathParam (value = "nurseId") Long nurseId, @PathParam (value = "doctorId") Long doctorId){
		return new ResponseEntity<String>(receptionistService.assignNursetoDoctor(nurseId, doctorId), HttpStatus.OK);
	}
}
