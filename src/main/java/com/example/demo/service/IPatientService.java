package com.example.demo.service;

import com.example.demo.model.Patient;

public interface IPatientService {
	
	public String createNewPatient( Patient patient);
	public String updatePatient(Long patientNumber, Patient patient);
	public String deletePatient (Long patientNumber);

}
