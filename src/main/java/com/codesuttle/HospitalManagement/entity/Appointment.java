package com.codesuttle.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 500)
    private String reason;

    @Column(length = 50)
    private String status;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false) // patient is required field , so nullable false
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false,name = "doctor_id")
    private Doctor doctor;
}
