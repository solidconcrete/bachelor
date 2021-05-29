package com.bachelor.bachelor.bl.appointment.service.impl;

import com.bachelor.bachelor.bl.appointment.repository.AppointmentRepository;
import com.bachelor.bachelor.bl.appointment.service.AppointmentService;
import com.bachelor.bachelor.bl.employee.repository.EmployeeRepository;
import com.bachelor.bachelor.bl.patient.repository.PatientRepository;
import com.bachelor.bachelor.bl.user.repository.UserRepository;
import com.bachelor.bachelor.model.Patient.Patient;
import com.bachelor.bachelor.model.appointment.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findUserAppointments(Authentication authentication) {
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals("PATIENT")) {
                return appointmentRepository.findByPatient(patientRepository.findByUser(userRepository.findByUsername(authentication.getName())));
            }
            if (grantedAuthority.getAuthority().equals("DOCTOR")) {
                return appointmentRepository.findByEmployee(employeeRepository.findByUser(userRepository.findByUsername(authentication.getName())));
            }
        }
       return null;
    }

    @Override
    public void upsertAppointment(Appointment appointment, Authentication authentication) {

        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            String a = authentication.getName();
            if (grantedAuthority.getAuthority().equals("PATIENT")) {
                if (!appointment.getPatient().getId().equals(patientRepository.findByUser(userRepository.findByUsername(authentication.getName())).getId()))
                throw new IllegalArgumentException();
            }
        }
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAppointmentsBetween(Appointment appointment) {
        return appointmentRepository.findAppointmentsByFromAfterAndUntilBefore(appointment.getFrom(), appointment.getUntil());
    }

}
