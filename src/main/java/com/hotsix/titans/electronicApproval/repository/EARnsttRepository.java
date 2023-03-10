package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EARnstt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EARnsttRepository extends JpaRepository<EARnstt, String> {
    EARnstt findByEaCode(String eaCode);
}
