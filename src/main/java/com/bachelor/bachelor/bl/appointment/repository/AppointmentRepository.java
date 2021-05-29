package com.bachelor.bachelor.bl.appointment.repository;

import com.bachelor.bachelor.model.Patient.Patient;
import com.bachelor.bachelor.model.appointment.Appointment;
import com.bachelor.bachelor.model.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findAppointmentsByFromAfterAndUntilBefore(LocalDateTime from, LocalDateTime until);
    List<Appointment> findByPatient(Patient patient);
    List<Appointment> findByEmployee(Employee employee);
}
