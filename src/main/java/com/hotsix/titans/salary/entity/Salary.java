package com.hotsix.titans.salary.entity;

import com.hotsix.titans.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_SALARY")
public class Salary {

    @Id
    @Column(name = "SALARY_CODE")
    private String salaryCode;              // 급여 코드

    @Column(name = "BASIC_SALARY")
    private Long basicSalary;               // 기본급

    @Column(name = "BEFORE_SALARY")
    private Long beforeSalary;              // 세전 급액

    @Column(name = "AFTER_SALARY")
    private Long afterSalary;               // 세후 급액

    @Column(name = "MEAL_SALARY")
    private Long mealSalary;                // 식대

    @JoinColumn(name = "MEMBER_CODE")
    @ManyToOne
    private Member member;                  // 멤버 테이블 다대일 매핑

}
