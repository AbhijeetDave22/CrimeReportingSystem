package com.crs.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotBlank(message = "Please enter the Complaint")
    @Size(min = 2, message = "Complaint must have a minimum of 2 characters")
    @Column(length = 3000)
    private String text;

    @NotNull
    @NotBlank(message = "Please enter the Complaint Status")
    @Size(min = 2, message = "Status must have a minimum of 2 characters")
    private String status = "Investigation Pending";

    private String imagePath;

    
}