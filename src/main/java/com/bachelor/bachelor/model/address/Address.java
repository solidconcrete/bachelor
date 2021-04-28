package com.bachelor.bachelor.model.address;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@ToString
@Getter
@Document(collection = "address")
public class Address {

    @Id
    private String id;
    @NotNull
    @NotEmpty
    private String country;
    @NotNull
    @NotEmpty
    private String municipality;
    @NotNull
    @NotEmpty
    private String settlement;
    @NotNull
    @NotEmpty
    private String street;
    @NotNull
    @NotEmpty
    @Field(name = "house_number")
    private String houseNo;

}
