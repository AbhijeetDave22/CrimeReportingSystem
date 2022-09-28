package com.crs.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.crs.pojos.Complaint;
import com.crs.pojos.User;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, message = "Name must have a minimum of 2 Characters")
    private String name;
    private String email;

    @Valid
    @OneToMany(targetEntity = Complaint.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaint;
    
    public void setComplaint(Complaint savedComplaint) {
        this.complaint.add(savedComplaint);
    }


    
}