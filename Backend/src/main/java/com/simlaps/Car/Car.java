package com.simlaps.Car;

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
public class Car {
    
    @Id
    private String carId;

    @NotNull
    @Field(name = "brand")
    private String brand;

    @NotNull
    @Field(name = "model")
    private String model;

    @Field(name = "year")
    private int year;

    @Field(name = "horsepower")
    private int horsepower;

    @Field(name = "weight")
    private int weight;

}
