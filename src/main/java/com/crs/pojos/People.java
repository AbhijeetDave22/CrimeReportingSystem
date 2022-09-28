package com.crs.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString



@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotBlank(message = "Please enter Phone Number")
    @Size(min = 2, message = "Name must have a minimum of 2 characters")
    private String name;

    @NotNull(message = "Please enter Phone Number")
    private long phoneNumber;

    @Valid
    @OneToOne(targetEntity = EmergencyComplaint.class, cascade = CascadeType.ALL)
    private EmergencyComplaint emergencyComplaint;

   
}