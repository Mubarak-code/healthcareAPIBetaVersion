package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "medicine_name", nullable = false)
	@NotBlank(message = "name cannot be blank")
	private String name;
	@Column(name = "manufacture_date", nullable = false)
	@NotBlank(message = "manufacture date cannot be blank")
	@DateTimeFormat(pattern = "mm-dd-yyyy")
	private LocalDate manufactureDate;
	@NotBlank(message = "expiry date cannot be blank")
	@Column(name = "expiry_date", nullable = false)
	@Future(message = "Expiry date must be a future date")
	@DateTimeFormat(pattern = "mm-dd-yyyy")
	private LocalDate expirtyDate;
	@Column(name = "manufacture_name", nullable = false)
	@NotBlank(message = "manufacture name cannot be blank")
	private String manufacturerName;
	@Positive(message = "dose must be a positive number")
	@Column(name = "dose", nullable = true)
	private String dose;
	
	
	public Medicine () {
		
	}


	public Medicine(String name, LocalDate manufactureDate,
			@Future(message = "Expiry date must be a future date") LocalDate expirtyDate, String manufacturerName) {
		super();
		this.name = name;
		this.manufactureDate = manufactureDate;
		this.expirtyDate = expirtyDate;
		this.manufacturerName = manufacturerName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getManufactureDate() {
		return manufactureDate;
	}


	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}


	public LocalDate getExpirtyDate() {
		return expirtyDate;
	}


	public void setExpirtyDate(LocalDate expirtyDate) {
		this.expirtyDate = expirtyDate;
	}


	public String getManufacturerName() {
		return manufacturerName;
	}


	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}


	public String getDose() {
		return dose;
	}


	public void setDose(String dose) {
		this.dose = dose;
	}


	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", manufactureDate=" + manufactureDate + ", expirtyDate="
				+ expirtyDate + ", manufacturerName=" + manufacturerName + ", dose=" + dose + "]";
	}
	
	
	

}
