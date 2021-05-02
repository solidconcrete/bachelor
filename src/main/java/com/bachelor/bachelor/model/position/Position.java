package com.bachelor.bachelor.model.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Document (collection = "position")
public class Position {

    @Id
    private String id;
    @NotNull
    @NotEmpty
    private String name;
    @JsonProperty
    private boolean doctor;
}
