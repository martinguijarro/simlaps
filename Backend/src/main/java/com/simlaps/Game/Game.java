package com.simlaps.Game;

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
public class Game {
    
    @Id
    private String gameId;

    @NotNull
    @Field(name = "name")
    private String name;

    @NotNull
    @Field(name = "developer")
    private String developer;

    @NotNull
    @Field(name = "year")
    private int year;

}
