package com.bachelor.bachelor.model.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Document (collection = "position")
public class Position {

    @NotNull
    @NotEmpty
    private String name;

    @JsonProperty
    private boolean doctor;
}
