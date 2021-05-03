package com.bachelor.bachelor.bl.appointment.repository;

import com.bachelor.bachelor.model.appointment.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
}
