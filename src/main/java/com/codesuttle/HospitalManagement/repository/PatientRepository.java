package com.codesuttle.HospitalManagement.repository;

import com.codesuttle.HospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByPatientName(String name);
    List<Patient> findByEmail(String email);

    // @Query is used to write SQL query
    @Query("Select p from Patient p Where p.gender = ?1")
    List<Patient> findByGender(@Param("gender") String gender);

    @Query("Select p from Patient p where p.patientDob > :patientDob")
    List<Patient> findByBornAfterDate(@Param("patientDob") LocalDate dob);


    @Query(value = "select * from patient",nativeQuery = true)
    List<Patient> findAllPatient();
}
