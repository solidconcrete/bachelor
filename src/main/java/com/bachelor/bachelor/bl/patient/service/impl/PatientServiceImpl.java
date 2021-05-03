package com.bachelor.bachelor.bl.patient.service.impl;

import com.bachelor.bachelor.bl.patient.repository.PatientRepository;
import com.bachelor.bachelor.bl.patient.service.PatientService;
import com.bachelor.bachelor.model.Patient.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void upsertPatient(Patient patient) {
        patientRepository.save(patient);
    }
}
