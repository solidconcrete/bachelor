package com.bachelor.bachelor.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    @NotNull()
    private String name;
    private String surname;
    @Field(name = "personal_id")
    private String personalId;
    @Field(name = "phone_number")
    private String phoneNumber;
    private String email;
}
