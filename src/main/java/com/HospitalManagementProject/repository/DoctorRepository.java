package com.HospitalManagementProject.repository;



import com.HospitalManagementProject.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    // Custom query methods can be added here if needed
}

