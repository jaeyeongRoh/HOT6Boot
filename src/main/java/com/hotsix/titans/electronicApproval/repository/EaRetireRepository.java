package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaRetire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaRetireRepository extends JpaRepository<EaRetire, String> {
    EaRetire findByEaCode(String eaCode);

    List<EaRetire> findAllByEaStatusCode(String status);
}
