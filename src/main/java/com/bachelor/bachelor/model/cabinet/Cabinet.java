package com.bachelor.bachelor.model.cabinet;

import com.bachelor.bachelor.model.address.Address;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Document(collection = "cabinet")
public class Cabinet {

    @Id
    private String id;
    @DBRef
    @NotNull
    private Address address;
    private short floor;
    @NotNull
    @NotEmpty
    @Field(name = "cabinet_number")
    private String cabinetNumber;
    private String department;
    private String wing;
    @Field(name = "additional_info")
    private String additionalInfo;
}
