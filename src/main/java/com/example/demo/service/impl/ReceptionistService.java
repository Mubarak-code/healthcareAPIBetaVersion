package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Nurse;
import com.example.demo.model.Patient;
import com.example.demo.model.Receptionist;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.NurseRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.ReceptionistRepository;
import com.example.demo.service.IReceptionistService;
import com.example.demo.validation.CustomValidator;

@Service
public class ReceptionistService implements IReceptionistService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private ReceptionistRepository receptionistRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private CustomValidator customValidator;

	@Override
	public String assignPatienttoDoctor(Long patientId, Long doctorId) {
		// TODO Auto-generated method stub
		Patient patient = patientRepository.findById(patientId).get();
		
		Doctor doctor = doctorRepository.findById(doctorId).get();
		
		if (doctor != null  && patient != null) {
			doctor.addPatient(patient);
			doctorRepository.save(doctor);
			return "Doctor "+doctor.getDoctorName()+ " has been assigned to patient "+patient.getPatientName();
		}
		return "Information missing ";
	}
	
	@Override
	public List<Receptionist> getAllReceptionist() {
		
		return receptionistRepository.findAll();
	}

	@Override
	public String newReceptionist(Receptionist receptionist) {
		customValidator.validateEntity(receptionist);
		receptionistRepository.save(receptionist);
		return "Opeation succesful";
	}

	@Override
	public String assignNursetoDoctor(Long nurseId, Long doctorId) {
		Nurse nurse = nurseRepository.findById(nurseId).get();
		Doctor doctor = doctorRepository.findById(doctorId).get();
		doctor.addNurse(nurse);
		doctorRepository.save(doctor);
		return "operation successful";
	}

}
