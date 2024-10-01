package com.HospitalManagementProject.repository;


import com.HospitalManagementProject.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorIdAndAppointmentDateBetween(Long doctorId, Date startDate, Date endDate);
    List<Appointment> findByPatientId(Long patientId);
}
