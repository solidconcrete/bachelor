package com.bachelor.bachelor.controller.patient;


import com.bachelor.bachelor.bl.patient.service.PatientService;
import com.bachelor.bachelor.model.Patient.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }

    @PostMapping
    public void upsertPatient(@RequestBody @Valid Patient patient) {
        patientService.upsertPatient(patient);
    }

}
