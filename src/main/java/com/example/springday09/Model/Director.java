package com.example.springday09.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    @NotNull(message ="ID field is required" )
    private int id ;

    @NotEmpty(message ="name field is required" )
    @Size(min = 2 , message = "Director Name length must be more than 2")
    private String name;

}
