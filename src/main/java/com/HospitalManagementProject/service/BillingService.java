package com.HospitalManagementProject.service;



import com.HospitalManagementProject.billing.Billing;
import com.HospitalManagementProject.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public Optional<Billing> getBillingById(Long id) {
        return billingRepository.findById(id);
    }

    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    public Billing updateBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public void deleteBilling(Long id) {
        billingRepository.deleteById(id);
    }
}

