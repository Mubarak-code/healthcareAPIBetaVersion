package com.example.demo.service;

import com.example.demo.model.Medicine;
import com.example.demo.model.Patient;

public interface INurseService {
	
	public String giveMedicine(Medicine medicine, Patient patient);
}
