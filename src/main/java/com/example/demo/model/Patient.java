package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "patient")
public class Patient  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "patient_number", nullable = false)
	@NotNull(message = "Patient number caanot be blank")
	private Long patientNumber;
	@Column(name =  "patient_name", nullable = false)
	@NotEmpty(message = "Patient name caanot be blank")
	private String patientName;
	@Column(name = "address", nullable = false)
	@NotEmpty(message = "Patient address must be entered")
	private String address;
	@Column(name = "phone_number", nullable = false)
	@NotNull(message = "Patient phone number must be entered")
	private Long phoneNumber;
	@Column(name = "email_address", nullable = true)
	@Email(message = "email should be valid")
	private String email;
	@Column(name = "diagnostic", nullable = true)
	private String diagnostic;
	
	// private Doctor doctor;
	
	public Patient () {
		
	}

	public Patient(@NotNull Long patientNumber, @NotEmpty String patientName,@NotNull Long phoneNumber,@NotEmpty String address) {
		this.patientNumber = patientNumber;
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(Long patientNumber) {
		this.patientNumber = patientNumber;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	/*
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	*/

	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientNumber=" + patientNumber + ", patientName=" + patientName + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", diagnostic=" + diagnostic + "]";
	}
	
	
}
