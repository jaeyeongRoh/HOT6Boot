package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EARnstt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EARnsttRepository extends JpaRepository<EARnstt, String> {
    EARnstt findByEaCode(String eaCode);

    List<EARnstt> findAllByEaStatusCode(String status);
}
