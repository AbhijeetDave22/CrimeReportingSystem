package com.crs.pojos;

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
public class EmergencyComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NotNull
    @NotBlank(message = "Please enter Emergency Complaint")
    @Size(min = 2, message = "Emergency must have a minimum of 2 characters")
    private String complaint;

    @NotNull
    @NotBlank(message = "Please enter Emergency Complaint Status")
    @Size(min = 2, message = "Emergency must have a minimum of 2 characters")
    private String status = "Investigation Pending";

   
}