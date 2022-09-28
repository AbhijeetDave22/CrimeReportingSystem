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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotNull
    @NotBlank(message = "Password cannot be blank")
    private String password;

    private boolean active = true;

    private String roles = "ROLE_USER";

    @Valid
    @OneToOne(targetEntity = Citizen.class, cascade = CascadeType.ALL)
    private Citizen citizen;

    @OneToOne(targetEntity = Police.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Police police;

    @OneToOne(targetEntity = Admin.class, cascade = CascadeType.ALL)
    private Admin admin;

    
}