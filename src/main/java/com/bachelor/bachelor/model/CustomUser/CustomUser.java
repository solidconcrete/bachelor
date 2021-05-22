package com.bachelor.bachelor.model.CustomUser;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Document (collection = "user")
public class CustomUser {
    @Id
    private String id;
    private String username;
    private String password;
    @Field
    private String[] roles;
}
