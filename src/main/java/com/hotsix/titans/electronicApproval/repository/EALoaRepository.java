package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EALoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EALoaRepository extends JpaRepository<EALoa, String> {
    List<EALoa> findAll();

    EALoa findByEaCode(String eaCode);
}
