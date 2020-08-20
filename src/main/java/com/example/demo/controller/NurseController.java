package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Nurse;
import com.example.demo.service.impl.NurseService;

@RequestMapping("/api/nurse")
@RestController
public class NurseController {
	
	@Autowired
	private NurseService nurseService;

	@PostMapping("/createnewnurse")
	public ResponseEntity<String> createNewNurse(@Valid  @RequestBody Nurse nurse){
		return new ResponseEntity<String>(nurseService.newNurse(nurse), HttpStatus.OK);
	}
	
	public ResponseEntity<List<Nurse>> getallNurses(){
		List<Nurse> allNurses = nurseService.getAllNurses();
		return new ResponseEntity<List<Nurse>>(allNurses, HttpStatus.OK);
	}
}
