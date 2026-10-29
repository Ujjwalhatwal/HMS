package com.codesuttle.HospitalManagement;

import com.codesuttle.HospitalManagement.entity.Patient;
import com.codesuttle.HospitalManagement.repository.PatientRepository;
import com.codesuttle.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientServices(){
        Patient patient= patientService.getPatientById(1L);
        System.out.println(patient);
    }
    @Test
    public void testPatientRepo(){
//        List<Patient> allPatient = patientRepo.findAll();
//        System.out.println(allPatient);

        Patient patient = patientRepo.findByPatientName("John Doe");
        List<Patient> p2 = patientRepo.findByEmail("ava.thomas@example.com");
        List<Patient> p1 = patientRepo.findByGender("Male");
        List<Patient> p3 = patientRepo.findByBornAfterDate(LocalDate.of(1980,1,1));
        List<Patient> p4 = patientRepo.findAllPatient();
        System.out.println(p2);
        System.out.println(patient);
        System.out.println(p1);
        System.out.println(p3);
        System.out.println(p4);
    }


}
