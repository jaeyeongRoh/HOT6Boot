package com.hotsix.titans.salary.entity;

import com.hotsix.titans.salary.entity.Salary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_BONUS_SALARY")
public class Bonus {

    @Id
    @Column(name = "BONUS_CODE")                // 상여 코드
    private String bonusCode;

    @Column(name = "BONUS_SALARY_TYPE")         // 상여 구분
    private String bonusType;

    @Column(name = "BONUS_SALARY")              // 상여 금액
    private Long bonusSalary;

    @Column(name = "BONUS_PAYMENTS_DATE")       // 지급일
    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "SALARY_CODE")           // 급여 테이블 다대일 매핑
    private Salary salary;
}

