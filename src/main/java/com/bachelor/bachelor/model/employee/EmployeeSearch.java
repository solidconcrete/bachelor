package com.bachelor.bachelor.model.employee;

import com.bachelor.bachelor.model.position.Position;
import lombok.Getter;

@Getter
public class EmployeeSearch {

    private String name;
    private String surname;
    private String positionId;
    private Boolean doctor;
}
