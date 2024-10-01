package com.HospitalManagementProject.repository;
import com.HospitalManagementProject.billing.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
    // Custom queries can be added here if needed
}

