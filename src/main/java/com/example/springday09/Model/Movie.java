package com.example.springday09.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor // always with entity
public class Movie {

    @Id
    @NotNull(message ="ID field is required" )
    private int id ;
    @NotNull(message ="directorID field is required" )
    private int directorID;

    @NotEmpty(message ="name field is required" )
    @Size(min = 2 , message = "Movie Name length must be more than 2")
    private String name;

    @NotEmpty(message ="genre field is required" )
    @Pattern( regexp = "^Drama|Action|Comedy$" ,message = "Genre field only allow input: Drama, Action, Comedy" )
    private String genre;

    @NotNull(message ="Rating field is required" )
    @Min(1)
    @Max(5)
    private double rate;

    @NotNull(message ="Duration field is required" )
    @Min(60)
    @Max(120)
    private int duration;






}
