package com.bachelor.bachelor.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@ToString
@Getter
@Document(collection = "employee")
public class Employee {

    @Id

    private ObjectId id;
    private String name;
    private String surname;
    @Field(name = "personal_id")
    private String personalId;
    @Field(name = "phone_number")
    private String phoneNumber;
}
