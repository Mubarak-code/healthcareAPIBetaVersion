package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long>{

}
