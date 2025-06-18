package com.simlaps.Circuit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Circuit {
    
    @Id
    private String circuitId;

    @NotNull
    @Field(name = "name")
    private String name;

    @NotNull
    @Field(name = "country")
    private String country;

    @NotNull
    @Field(name = "length")
    private String length;

}
