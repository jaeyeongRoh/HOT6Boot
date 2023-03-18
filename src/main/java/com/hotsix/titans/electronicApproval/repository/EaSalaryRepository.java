package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaSalary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaSalaryRepository extends JpaRepository<EaSalary, String> {

    List<EaSalary> findAll();
    EaSalary findByEaCode(String eaCode);

    List<EaSalary> findAllByEaStatusCode(String status);
}
