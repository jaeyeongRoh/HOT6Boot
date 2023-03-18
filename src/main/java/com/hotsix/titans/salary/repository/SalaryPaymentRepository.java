package com.hotsix.titans.salary.repository;

import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.entity.SalaryPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryPaymentRepository extends JpaRepository<SalaryPayment, String> {

    SalaryPayment findBySalaryCode(String selectedSalaryCode);
}
