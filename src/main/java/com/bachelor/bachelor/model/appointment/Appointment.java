package com.bachelor.bachelor.model.appointment;

import com.bachelor.bachelor.model.Patient.Patient;
import com.bachelor.bachelor.model.cabinet.Cabinet;
import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.model.position.Position;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Document (collection = "appointment")
public class Appointment {

    @Id
    private String id;
    @NotNull
    private LocalDateTime from;
    @NotNull
    private LocalDateTime until;
    @DBRef
    @NotNull
    private Employee employee;
    @DBRef
    @NotNull
    private Cabinet cabinet;
    @DBRef
    @NotNull
    private Position position;
    @DBRef
    @NotNull
    private Patient patient;
}
