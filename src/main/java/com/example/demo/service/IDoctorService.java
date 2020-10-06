package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Doctor;
import com.example.demo.model.Employee;
import com.example.demo.model.Patient;
import org.springframework.data.domain.Page;

public interface IDoctorService {
	
	public String givePatientDiagnostic(String message, Long doctorId ,Long patientId);
	public String prescribeMedicine(Long medicineId, Long nurseId, Long doctorId, Long patientId);
	public List<Patient> getAllPatient(Long doctorId);
	public String newDoctor(Doctor doctor);
	

}
