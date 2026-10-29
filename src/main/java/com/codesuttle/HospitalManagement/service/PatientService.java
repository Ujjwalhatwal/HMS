package com.codesuttle.HospitalManagement.service;

import com.codesuttle.HospitalManagement.entity.Patient;
import com.codesuttle.HospitalManagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientService  {

    private final PatientRepository patientRepo;

    @Transactional
    public Patient getPatientById(Long id){
        return patientRepo.findById(id).orElse(null);
    }

}
