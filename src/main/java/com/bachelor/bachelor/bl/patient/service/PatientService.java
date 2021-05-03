package com.bachelor.bachelor.bl.patient.service;

import com.bachelor.bachelor.model.Patient.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAllPatients();
    void upsertPatient(Patient patient);
}
