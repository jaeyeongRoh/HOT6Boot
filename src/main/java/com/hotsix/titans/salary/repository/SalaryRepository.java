package com.hotsix.titans.salary.repository;

import com.hotsix.titans.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, String> {

    /* 년도와 월로 급여 조회 */
    Salary findBySalaryCode(Integer paypaymentYear, Integer paymentMonth);

    /* 지급 상태에 따른 급여 전체 조회 */
    List<Salary> findBySalaryPayment(String salaryPaymentYn);

}

