package com.crs.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2, message = "Individual's Name must have a minimum of 2 characters")
    @NotBlank(message = "Please enter name of the Criminal")
    private String name;

    @NotNull
    @Size(min = 2, message = "Location must have a minimum of 2 characters")
    @NotBlank(message = "Please enter location")
    private String location;

    @NotNull
    @Min(value = 0, message = "Age should not be less than 0")
    private int age;

    @NotNull
    @Size(min = 2, message = "Status must have 2 characters")
    @NotBlank(message = "Please enter age of the Criminal")
    private String status;

    @NotNull
    @Size(min = 2, message = "Type must have 2 characters")
    @NotBlank(message = "Please enter type of the Criminal")
    private String type;

    
}