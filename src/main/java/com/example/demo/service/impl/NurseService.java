package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Medicine;
import com.example.demo.model.Nurse;
import com.example.demo.model.Patient;
import com.example.demo.repository.NurseRepository;
import com.example.demo.service.INurseService;
import com.example.demo.validation.CustomValidator;

@Service
public class NurseService implements INurseService {
	@Autowired
	private CustomValidator customValidator;
	@Autowired
	private NurseRepository nurseRepository;

	@Override
	public String giveMedicine(Medicine medicine, Patient patient) {
		 
		return "administering medicince to "+patient.getPatientName();
	}
	
	public String newNurse(Nurse nurse) {
		customValidator.validateEntity(nurse);
		nurseRepository.save(nurse);
		return "Opeation succesful";
	}
	
	public List<Nurse> getAllNurses(){
		return nurseRepository.findAll();
	}

}
