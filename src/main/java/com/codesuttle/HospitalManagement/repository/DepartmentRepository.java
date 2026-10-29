package com.codesuttle.HospitalManagement.repository;

import com.codesuttle.HospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}