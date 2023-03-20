package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaLeaveRepository extends JpaRepository<EaLeave, String> {

    List<EaLeave> findAll();
    EaLeave findByEaCode(String eaCode);

    List<EaLeave> findAllByEaStatusCode(String status);
}
