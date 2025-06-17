package com.simlaps.Lap;

import java.time.LocalDateTime;

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
public class Lap {
    
    @Id
    private String lapId;

    @NotNull
    @Field(name = "date")
    private LocalDateTime date;

    @NotNull
    @Field(name = "time")
    private String time;

    @NotNull
    @Field(name = "user_id")
    private String userId;

    @NotNull
    @Field(name = "circuit_id")
    private String circuitId;

    @NotNull
    @Field(name = "car_id")
    private String carId;

    @NotNull
    @Field(name = "game_id")
    private String gameId;

}
