package com.bachelor.bachelor.bl.appointment.service;

import com.bachelor.bachelor.model.appointment.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> findAllAppointments();
    void upsertAppointment (Appointment appointment);
}
