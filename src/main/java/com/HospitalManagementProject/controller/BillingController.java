package com.HospitalManagementProject.controller;


import com.HospitalManagementProject.billing.Billing;
import com.HospitalManagementProject.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping
    public ResponseEntity<Billing> createBilling(@RequestBody Billing billing) {
        Billing createdBilling = billingService.createBilling(billing);
        return new ResponseEntity<>(createdBilling, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable Long id) {
        Optional<Billing> billing = billingService.getBillingById(id);
        return billing.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Billing>> getAllBillings() {
        List<Billing> billings = billingService.getAllBillings();
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable Long id, @RequestBody Billing billing) {
        if (!billingService.getBillingById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        billing.setId(id);
        Billing updatedBilling = billingService.updateBilling(billing);
        return new ResponseEntity<>(updatedBilling, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable Long id) {
        if (!billingService.getBillingById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        billingService.deleteBilling(id);
        return ResponseEntity.noContent().build();
    }
}

