package com.example.demo.model;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private Long id;
	
	
	@Column(name = "doctor_name")
	@NotBlank(message = "doctor name cannot be blank")
	@Length(min = 1)
	private String doctorName;
	@Column(name = "doctor_number", nullable = false)
	@NotNull(message = "doctor number cannot be blank" )
	private Long doctorNumber;
	@Column(name = "doctor_phone_number", nullable = false)
	@NotNull(message = "Phone number must be entered")
	private Long phoneNumber;
	@Column(name = "email_address", nullable = true)
	@Email(message = "e-mail should be valid")
	private String emailAddress;
	/*
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "employee_id", nullable = true)
	private Employee employee;
	*/
	@NotEmpty(message = " EmployeeType cannot be empty")
	@Column(name = "employment_type", nullable = false)
	private String employmentType;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_patient")
	private List<Patient> patients;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_nurse")
	private List<Nurse> nurses;
	
	public Doctor() {
		
	}
	public Doctor(@NotNull Long doctorNumber, @NotBlank String doctorName,@NotNull Long phoneNumber, @NotEmpty String employmentType) {
		this.doctorNumber = doctorNumber;
		this.doctorName = doctorName;
		this.phoneNumber = phoneNumber;
		this.employmentType = employmentType;
			
	}
	

	public Doctor(@NotNull Long doctorNumber, @NotBlank String doctorName,@NotNull Long phoneNumber, String email ,@NotEmpty String employmentType) {
		this.doctorNumber = doctorNumber;
		this.doctorName = doctorName;
		this.phoneNumber = phoneNumber;
		this.employmentType = employmentType;	
		this.emailAddress = email;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}
	
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
	
	public void addNurse(Nurse nurse) {
		nurses.add(nurse);
	}
	
	public Patient getPatient(Long patientId) {
		for (Patient patient : patients) {
			if(patient.getId() == patientId)
				return patient;
			else
				continue;
		}
			return null;
	}
	
	public Nurse getNurse(Long nurseId) {
		for (Nurse nurse : nurses) {
			if(nurse.getId() == nurseId)
				return nurse;
			else
				continue;
		}
			return null;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Long getDoctorNumber() {
		return doctorNumber;
	}
	public void setDoctorNumber(Long doctorNumber) {
		this.doctorNumber = doctorNumber;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/*
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	*/
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	


}
