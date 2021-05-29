package com.bachelor.bachelor.model.employee;

import com.bachelor.bachelor.model.CustomUser.CustomUser;
import com.bachelor.bachelor.model.position.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@ToString
@Getter
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    @NotNull(message = "employee name can not be null")
    @NotEmpty(message = "employee name can not be empty")
    private String name;
    @NotNull(message = "employee surname can not be null")
    @NotEmpty(message = "employee surname can not be empty")
    private String surname;
    @Field(name = "personal_id")
    private String personalId;
    @Field(name = "phone_number")
    private String phoneNumber;
    private String email;

    @DBRef
    @NotNull
    @NotEmpty
    private List<Position> positions;

    @DBRef
    @NotNull
    private CustomUser user;

}
