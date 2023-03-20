package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaLoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaLoaRepository extends JpaRepository<EaLoa, String> {
    List<EaLoa> findAll();

    EaLoa findByEaCode(String eaCode);

    List<EaLoa> findAllByEaStatusCode(String status);
}
