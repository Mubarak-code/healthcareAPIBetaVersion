package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "receptionist")
public class Receptionist{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "receptinoist_name", nullable = false)
	@NotBlank(message = "receptionist name cannot be blank")
	@Length(min = 1)
	private String receptionistName;
	@Column(name = "receptionist_number", nullable = false)
	@NotNull(message = "receptinoist number cannot be blank" )
	private Long receptionistNumber;
	@Column(name = "receptinoist_phone_number", nullable = false)
	@NotNull(message = "Phone number must be entered")
	private Long phoneNumber;
	@Column(name = "email_address", nullable = true)
	@Email(message = "e-mail should be valid")
	private String emailAddress;
	@NotEmpty (message = "employee type cannot be empty")
	@Column(name = "employment_type", nullable = false)
	private String employmentType;
	
	public Receptionist() {
		
	}
	
	public Receptionist(@NotNull Long receptionistNumber, @NotBlank String receptionistName,@NotNull Long phoneNumber, @NotEmpty String employmentType) {
		this.receptionistNumber = receptionistNumber;
		this.receptionistName = receptionistName;
		this.phoneNumber = phoneNumber;
		this.employmentType = employmentType;
			
	}
	
	
	
	public Receptionist(@NotNull Long receptionistNumber, @NotBlank String receptionistName,@NotNull Long phoneNumber, String email ,@NotEmpty String employmentType) {
		this.receptionistNumber = receptionistNumber;
		this.receptionistName = receptionistName;
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

	public String getReceptionistName() {
		return receptionistName;
	}

	public void setReceptionistName(String receptionistName) {
		this.receptionistName = receptionistName;
	}

	public Long getReceptionistNumber() {
		return receptionistNumber;
	}

	public void setReceptionistNumber(Long receptionistNumber) {
		this.receptionistNumber = receptionistNumber;
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
