package com.bachelor.bachelor.controller.appointment;

import com.bachelor.bachelor.TenantProvider;
import com.bachelor.bachelor.bl.appointment.service.AppointmentService;
import com.bachelor.bachelor.model.appointment.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/admin/appointments")
    public List<Appointment> findAllAppointments() {
        return appointmentService.findAllAppointments();
    }

    @GetMapping("/appointments")
    public List<Appointment> findAllUserAppointments(Authentication authentication) {
        return appointmentService.findUserAppointments(authentication);
    }

    @PostMapping("/appointments")
    public void upsertAppointment(@RequestBody Appointment appointment, Authentication authentication) {
        appointmentService.upsertAppointment(appointment, authentication);
    }

    @PostMapping("/appointments/search")
    public List<Appointment> findAppointments(@RequestBody Appointment appointment) {
        return appointmentService.findAppointmentsBetween(appointment);
    }

}
