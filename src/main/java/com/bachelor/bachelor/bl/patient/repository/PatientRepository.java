package com.bachelor.bachelor.bl.patient.repository;

import com.bachelor.bachelor.model.Patient.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
