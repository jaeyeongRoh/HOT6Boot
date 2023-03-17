package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EACert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EACertRepository extends JpaRepository<EACert, String> {
    List<EACert> findAll();

    EACert findByEaCode(String eaCode);

    List<EACert> findAllByEaStatusCode(String status);
}
