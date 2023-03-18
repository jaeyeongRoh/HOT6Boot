package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaRnstt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaRnsttRepository extends JpaRepository<EaRnstt, String> {
    EaRnstt findByEaCode(String eaCode);

    List<EaRnstt> findAllByEaStatusCode(String status);
}
