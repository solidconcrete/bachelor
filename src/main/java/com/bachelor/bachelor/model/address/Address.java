package com.bachelor.bachelor.model.address;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;

@ToString
@Getter
@Document(collection = "address")
public class Address {

    @Id
    private String id;
    @NotEmpty(message = "country can not be empty")
    private String country;
    @NotEmpty(message = "municipality can not be empty")
    private String municipality;
    @NotEmpty(message = "settlement can not be empty")
    private String settlement;
    @NotEmpty(message = "street can not be empty")
    private String street;
    @NotEmpty(message = "house number can not be empty")
    @Field(name = "house_number")
    private String houseNo;

}
