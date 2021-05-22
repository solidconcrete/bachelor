package com.bachelor.bachelor.controller.appointment;

import com.bachelor.bachelor.TenantProvider;
import com.bachelor.bachelor.bl.appointment.service.AppointmentService;
import com.bachelor.bachelor.model.appointment.Appointment;
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
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> findAllAppointments() {
        return appointmentService.findAllAppointments();
    }

    @PostMapping
    public void upsertAppointment(@RequestBody Appointment appointment) {
        appointmentService.upsertAppointment(appointment);
    }

    @PostMapping("/search")
    public List<Appointment> findAppointments(@RequestBody Appointment appointment) {
        return appointmentService.findAppointmentsBetween(appointment);
    }

}
