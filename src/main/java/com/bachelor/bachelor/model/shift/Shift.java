package com.bachelor.bachelor.model.shift;

import com.bachelor.bachelor.model.cabinet.Cabinet;
import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.model.position.Position;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@ToString
@Document (collection = "shift")
public class Shift {

    @Id
    private String id;
    @NotNull
//    @JsonSerialize (using = LocalDateSerializer.class)
    private LocalDateTime from;
    @NotNull
    private LocalDateTime until;
    private LocalDateTime breakFrom;
    private LocalDateTime breakUntil;
    @DBRef
    @NotNull
    private Employee employee;
    @DBRef
    private Cabinet cabinet;
    @DBRef
    private Position position;

}
