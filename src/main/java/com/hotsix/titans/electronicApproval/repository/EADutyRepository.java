package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EADuty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EADutyRepository extends JpaRepository<EADuty, String> {
    EADuty findByEaCode(String eaCode);
}
