package com.hotsix.titans.salary.repository;

import com.hotsix.titans.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, String> {

    /* 날짜에 따른 급여 조회 */
    List<Salary> findByPaymentsYnAndPaymentDateBetween(String paymentsYn, Date start, Date end);
//    List<Salary> findByPaymentDateBetween(Date start, Date end, Integer memberCode);


    /* 지급 여부에 따른 급여 전체 조회 */
    List<Salary> findByPaymentsYn(String paymentsYn);


}

