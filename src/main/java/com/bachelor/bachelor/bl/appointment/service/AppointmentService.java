package com.bachelor.bachelor.bl.appointment.service;

import com.bachelor.bachelor.model.appointment.Appointment;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    List<Appointment> findAllAppointments();
    void upsertAppointment (Appointment appointment, Authentication authentication);
    List<Appointment> findAppointmentsBetween(Appointment appointment);
    List<Appointment> findUserAppointments(Authentication authentication);
}
