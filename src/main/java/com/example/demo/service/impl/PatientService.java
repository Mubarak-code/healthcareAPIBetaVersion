package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.IPatientService;
import com.example.demo.validation.CustomValidator;

@Service
public class PatientService implements IPatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private CustomValidator customValidator;

	@Override
	public String createNewPatient(Patient patient) {
		if (patient != null) {
			//validate constraint
			customValidator.validateEntity(patient);
			patientRepository.save(patient);
			return " operation successful";
		}
		return "Patient information not completed";
	}

	@Override
	public String updatePatient(Long patientNumber, Patient patient) {
		Patient patientInfofromDB = patientRepository.findByPatientNumber(patientNumber);
		if (patientInfofromDB != null) {
			patientInfofromDB.setPatientName(patient.getPatientName());
			patientInfofromDB.setPatientNumber(patient.getPatientNumber());
			patientInfofromDB.setPhoneNumber(patient.getPhoneNumber());
			return "Patient information updated";
		}
		return "Patient information not completed";
	}

	@Override
	public String deletePatient(Long patientNumber) {
		patientRepository.deleteByPatientNumber(patientNumber);;
		
		return "Patient information deleted";
	}

}
