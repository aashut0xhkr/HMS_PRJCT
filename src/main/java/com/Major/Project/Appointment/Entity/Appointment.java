package com.Major.Project.Appointment.Entity;

import com.Major.Project.Doctor.Entity.Doctor;
import com.Major.Project.Patient.Entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private LocalDateTime appointmentTime;
    private String status;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties("appointments")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnoreProperties("appointments")
    private Doctor doctor;

}
