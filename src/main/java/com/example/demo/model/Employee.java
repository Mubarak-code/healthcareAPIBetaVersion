package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "employee_name", nullable = false)
	@NotBlank(message = "employee name cannot be blank")
	@Length(min = 1)
	private String employeeName;
	@Column(name = "employee_number", nullable = false)
	@NotNull(message = "employee number cannot be blank" )
	private Long employeeNumber;
	@Column(name = "employee_phone_number", nullable = false)
	@NotNull(message = "Phone number must be entered")
	private Long phoneNumber;
	@Column(name = "email_address", nullable = true)
	@Email(message = "e-mail should be valid")
	private String emailAddress;
	/*
	@OneToMany
	@JoinColumn(name = "employee_id",  nullable = true )
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	private List<Doctor> doctors ;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "nurse_id", nullable = true)
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	private List<Nurse> nurses = new ArrayList<>();
	*/
	@NotEmpty(message = "employment type cannot be blank ")
	@Column(name = "employment_type")
	private String employmentType;
	
	public Employee() { }
		

	public Employee(@NotNull Long employeeNumber, @NotBlank String employeeName,@NotNull Long phoneNumber,@NotEmpty String employmentType) {
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.employmentType = employmentType;
			
	}
	
	
	
	public Employee(@NotNull Long employeeNumber, @NotBlank String employeeName,@NotNull Long phoneNumber, String email ,@NotEmpty String employeeType) {
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.employmentType = employeeType;	
		this.emailAddress = email;
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Long getEmployeeNumber() {
		return employeeNumber;
	}


	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
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
	
	public String getEmployeeType() {
		return employmentType;
	}
	
	public void setEmployeeType(String employmentType) {
		this.employmentType = employmentType;
	}
	/*
	public List<Doctor> getDoctors(){
		return doctors;
	}
	
	public void setDoctorList(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
	*/
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeNumber=" + employeeNumber
				+ ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + "]";
	}


	
	
	
	

}
