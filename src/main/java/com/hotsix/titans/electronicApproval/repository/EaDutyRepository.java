package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaDuty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaDutyRepository extends JpaRepository<EaDuty, String> {
    EaDuty findByEaCode(String eaCode);

    List<EaDuty> findAllByEaStatusCode(String status);
}
