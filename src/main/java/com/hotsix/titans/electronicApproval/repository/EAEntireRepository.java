package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EAEntire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EAEntireRepository extends JpaRepository<EAEntire, String> {
    EAEntire findByEaCode(String eaCode);
}
