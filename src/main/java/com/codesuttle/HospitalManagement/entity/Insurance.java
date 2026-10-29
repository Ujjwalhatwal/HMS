package com.codesuttle.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private Integer id;

    @Column(nullable = false,length = 100)
    private String provider;

    @Column(nullable = false,unique = true,length = 50)
    private String policyNumber;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDate validUntil;

    @OneToOne(mappedBy = "insurance") // inverse side
    private Patient patient;
}
