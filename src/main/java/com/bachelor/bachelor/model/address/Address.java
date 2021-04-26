package com.bachelor.bachelor.model.address;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@Getter
@Document(collection = "address")
public class Address {

    @Id
    private String id;
    private String country;
    private String municipality;
    private String settlement;
    private String street;
    @Field(name = "house_number")
    private String houseNo;

}
