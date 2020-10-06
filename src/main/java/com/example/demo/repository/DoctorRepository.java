package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Doctor;
import com.example.demo.model.Employee;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	Doctor findByDoctorNumber (Long doctorNumber);
	Doctor findByDoctorName (String doctorName);
	

}
