package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EARetire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EARetireRepository extends JpaRepository<EARetire, String> {
    EARetire findByEaCode(String eaCode);
}
