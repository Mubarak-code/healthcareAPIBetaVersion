package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Receptionist;

public interface IReceptionistService {
	
	public String assignPatienttoDoctor(Long patientId, Long doctorId);
	public String assignNursetoDoctor(Long nurseId, Long doctorId);
	public String newReceptionist(Receptionist receptionist);
	public List<Receptionist> getAllReceptionist();
}
