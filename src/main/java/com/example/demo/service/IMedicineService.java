package com.example.demo.service;

import com.example.demo.model.Medicine;

public interface IMedicineService {
	
	public String createNewMedicine(Medicine medicine);
	public String deleteMedicine(Long medicineId);

}
