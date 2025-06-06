package com.Major.Project.Billing.Entity;

import com.Major.Project.Patient.Entity.Patient;
import com.Major.Project.Staff.Entity.Staff;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billID;
    private Double amount;
    private String description;
    private LocalDateTime billingDate;
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties("billings")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff handledBy;
}
