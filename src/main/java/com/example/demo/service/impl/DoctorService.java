package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Employee;
import com.example.demo.model.Medicine;
import com.example.demo.model.Nurse;
import com.example.demo.model.Patient;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.IDoctorService;
import com.example.demo.validation.CustomValidator;



@Service
public class DoctorService implements IDoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private MedicineRepository medicineRepository;
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private NurseService nurseService;
	/*
	@Autowired
	private EmployeeRepository employeeRepository;
	*/
	@Autowired
	private CustomValidator customValidator;
	
	@Value("${page.size}")
	private int size;

	@Override
	public String givePatientDiagnostic(String message,Long doctorId ,Long patientId) {
		// check if doctor with doctorId is present
		Optional<Doctor> checkDoctor = doctorRepository.findById(doctorId);
		
		//if doctor is present , fetch doctor object and perform logic 
		if (checkDoctor.isPresent()) {
			Doctor doctor = checkDoctor.get();
			// validate constraint
			customValidator.validateEntity(doctor);
			
			//check if patient with patientId is under doctor's care
			Patient patient = doctor.getPatient(patientId);
			try {
				if (patient != null) 
					//validate constraint
					customValidator.validateEntity(patient);
					//set patient diagnostic
					patient.setDiagnostic(message);
					patientRepository.save(patient);
			}catch (NullPointerException ex) {
				return "patient not under doctor's care";
			}	
			return "operation succesful";
		}
		// if doctor with doctorId is not found
		return "Doctor information not found";
		
	}

	@Override
	public String prescribeMedicine(Long medicineId,Long nurseId, Long doctorId, Long patientId) {
		//check if doctor id is present
		Optional <Doctor> checkDoctor = doctorRepository.findById(doctorId);
		Optional <Medicine> checkMedicine = medicineRepository.findById(medicineId);
		//check if medicine is available in hospital pharmacy for administering
		if (!checkMedicine.isPresent())
			return "medicine is not available";
		if (checkDoctor.isPresent()) {
			Doctor doctor = checkDoctor.get();
			//validate constraint
			customValidator.validateEntity(doctor);
			//check if patient with patientId is under doctor's care
			Patient patient = doctor.getPatient(patientId);
			//validate constraint
			customValidator.validateEntity(patient);
			//check if nurse with nurseId is assigned to work with Doctor
			Nurse nurse = doctor.getNurse(nurseId);
			try {
				if (patient != null && nurse != null ) {
					nurseService.giveMedicine(checkMedicine.get(), patient);
					return "medicine prescribed and adminsitered by nurse";
				}
			}catch(NullPointerException ex) {
				return "Either Patient or Nurse are be associated with Doctor";
			}
		}
		// if doctor with doctorId is not found
		return "Doctor with doctorId not found";
	}

	@Override
	public List<Patient> getAllPatient(Long doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor = doctorRepository.findById(doctorId).get();		
		return doctor.getPatients();
	}

	//@Override
	public Page<Doctor> getallDoctors(int page, String sortField , String sortDirection) {
		Sort  sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortField).ascending():Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(page-1,size,sort);
		return (Page<Doctor>) pageable;
	}

	@Override
	public String newDoctor(Doctor doctor) {
		customValidator.validateEntity(doctor);
		doctorRepository.save(doctor);
		
		return "Operation succesful";
	}

}
