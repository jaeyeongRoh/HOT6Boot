package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaCert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaCertRepository extends JpaRepository<EaCert, String> {
    List<EaCert> findAll();

    EaCert findByEaCode(String eaCode);

    List<EaCert> findAllByEaStatusCode(String status);
}
