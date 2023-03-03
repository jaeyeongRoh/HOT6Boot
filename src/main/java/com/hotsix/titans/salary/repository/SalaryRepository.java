package com.hotsix.titans.salary.repository;

import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, String> {

    /* 년도와 월로 급여 조회 */
    List<Salary> findByPaymentDate(Date paymentDate);

    /* 지급 여부에 따른 급여 전체 조회 */
    List<Salary> findByPaymentsYn(String paymentsYn);


}

