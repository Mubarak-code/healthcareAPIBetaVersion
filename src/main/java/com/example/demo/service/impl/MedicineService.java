package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Medicine;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.service.IMedicineService;
import com.example.demo.validation.CustomValidator;

@Service
public class MedicineService implements IMedicineService {
	
	@Autowired
	private MedicineRepository  medicineRepository;
	
	@Autowired
	private CustomValidator cusomtValidator;

	@Override
	public String createNewMedicine(Medicine medicine) {
		//validate constraint
		cusomtValidator.validateEntity(medicine);
		
		medicineRepository.save(medicine);
		
		return "operation succesful";
	}



	@Override
	public String deleteMedicine(Long medicineId) {
		// TODO Auto-generated method stub
		
		medicineRepository.deleteById(medicineId);
		return "operation successful";
	}

}
