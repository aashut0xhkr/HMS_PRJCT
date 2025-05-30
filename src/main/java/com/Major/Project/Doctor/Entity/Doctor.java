package com.Major.Project.Doctor.Entity;

import com.Major.Project.Appointment.Entity.Appointment;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;
    @NotNull
    private String name;
    private String specialisation;
    private String contact;
    private String email;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "doctor-appointments")
    private List<Appointment> appointments;

}
