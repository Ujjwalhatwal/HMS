package com.codesuttle.HospitalManagement.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(
        name = "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_name_and_dob", columnNames = {"patient_name","patient_dob"})
        },
        indexes = @Index(name = "idx_patient_dob",columnList = "patient_dob")
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "patient_name")
    private String patientName;

//    @ToString.Exclude
    @Column(name = "patient_dob")
    private LocalDate patientDob;
    private String email;
    private String disease;
    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createAt;

    @OneToOne //owning side
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;


//    @Column(unique = true) // to make phone number is unique constraint
//    @Column(name = "phone_no")
//    private String phoneNo;
//    @Enumerated(EnumType.ORDINAL)
//        private BloodGroupType bloodGroup; // BloodGroupType is enum class

}
