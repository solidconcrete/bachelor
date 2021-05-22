package com.bachelor.bachelor.bl.appointment.repository;

import com.bachelor.bachelor.model.appointment.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findAppointmentsByFromAfterAndUntilBefore(LocalDateTime from, LocalDateTime until);
}
