package com.HospitalManagementProject.controller;


import com.HospitalManagementProject.entity.Appointment;
import com.HospitalManagementProject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Get appointments by doctor ID and date range
    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable Long doctorId,
                                                      @RequestParam Date startDate,
                                                      @RequestParam Date endDate) {
        return appointmentService.getAppointmentsForDoctor(doctorId, startDate, endDate);
    }

    // Get appointments by patient ID
    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsForPatient(patientId);
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        if (appointment.isPresent()) {
            return ResponseEntity.ok(appointment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new appointment
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    // Update appointment status
    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateAppointmentStatus(@PathVariable Long id, @RequestParam String status) {
        appointmentService.updateAppointmentStatus(id, status);
        return ResponseEntity.ok().build();
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
