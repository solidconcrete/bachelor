package com.bachelor.bachelor.model.Patient;

import com.bachelor.bachelor.model.position.Position;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Document (collection = "patient")
public class Patient {

    @Id
    private String id;
    @NotNull(message = "patient name can not be null")
    @NotEmpty(message = "patient name can not be empty")
    private String name;
    @NotNull(message = "patient surname can not be null")
    @NotEmpty(message = "patient surname can not be empty")
    private String surname;
    @Field(name = "personal_id")
    private String personalId;
    @Field(name = "phone_number")
    private String phoneNumber;
    private String email;
    private boolean isActive = true;
}
