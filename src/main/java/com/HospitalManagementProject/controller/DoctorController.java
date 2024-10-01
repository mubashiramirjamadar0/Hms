package com.HospitalManagementProject.controller;



import com.HospitalManagementProject.entity.Doctor;
import com.HospitalManagementProject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int id) {
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
//localhost:8080/hospital/id
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
        if (doctorService.getDoctorById(id).isPresent()) {
            doctor.setId(id);
            Doctor updatedDoctor = doctorService.saveDoctor(doctor);
            return ResponseEntity.ok(updatedDoctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int id) {
        if (doctorService.getDoctorById(id).isPresent()) {
            doctorService.deleteDoctor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

