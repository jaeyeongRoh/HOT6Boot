package com.hotsix.titans.salary.repository;

import com.hotsix.titans.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, String> {

}

