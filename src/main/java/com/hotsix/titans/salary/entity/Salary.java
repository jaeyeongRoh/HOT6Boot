package com.hotsix.titans.salary.entity;

import com.hotsix.titans.member.entity.Member;
import lombok.*;

import javax.persistence.*;

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

    public Salary() {
    }

    public Salary(String salaryCode, Long basicSalary, Long beforeSalary, Long afterSalary, Long mealSalary, Member member) {
        this.salaryCode = salaryCode;
        this.basicSalary = basicSalary;
        this.beforeSalary = beforeSalary;
        this.afterSalary = afterSalary;
        this.mealSalary = mealSalary;
        this.member = member;
    }

    public String getSalaryCode() {
        return salaryCode;
    }

    public void setSalaryCode(String salaryCode) {
        this.salaryCode = salaryCode;
    }

    public Long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Long getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Long beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Long getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Long afterSalary) {
        this.afterSalary = afterSalary;
    }

    public Long getMealSalary() {
        return mealSalary;
    }

    public void setMealSalary(Long mealSalary) {
        this.mealSalary = mealSalary;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryCode='" + salaryCode + '\'' +
                ", basicSalary=" + basicSalary +
                ", beforeSalary=" + beforeSalary +
                ", afterSalary=" + afterSalary +
                ", mealSalary=" + mealSalary +
                ", member=" + member +
                '}';
    }
}
