package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EASalary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EASalaryRepository extends JpaRepository<EASalary, Integer> {

    List<EASalary> findAll();
    EASalary findByEaCode(String eaCode);

}
