package com.bachelor.bachelor.bl.appointment.service.impl;

import com.bachelor.bachelor.bl.appointment.repository.AppointmentRepository;
import com.bachelor.bachelor.bl.appointment.service.AppointmentService;
import com.bachelor.bachelor.model.appointment.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;


    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void upsertAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAppointmentsBetween(Appointment appointment) {
        return appointmentRepository.findAppointmentsByFromAfterAndUntilBefore(appointment.getFrom(), appointment.getUntil());
    }

//     TODO:
//    1) add validation to new appointment
//    2) get available appointments for position in current time window
}
