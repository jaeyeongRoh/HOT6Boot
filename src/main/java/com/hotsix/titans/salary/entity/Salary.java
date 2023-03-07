package com.hotsix.titans.salary.entity;

import com.hotsix.titans.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_SALARY")
public class Salary {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salary_generator")
//    @GenericGenerator(name = "salary_generator", strategy = "com.hotsix.titan.generator.SalaryGenerator")
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

    @Column(name = "INCOM_TAX")
    private Long incomTax;

    @Column(name = "HEALTH_TAX")
    private Long healthTax;

    @Column(name = "NATIONAL_TAX")
    private Long nationalTax;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "SALARY_PAYMENTS_YN")
    private String paymentsYn;

    @ManyToOne
    @JoinColumn(name = "TAX_CODE")
    private Tax tax;

    @OneToOne
    @JoinColumn(name = "BONUS_CODE")
    private Bonus bonus;

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE")
    private Member member;

    @Override
    public String toString() {
        return "Salary{" +
                "salaryCode='" + salaryCode + '\'' +
                ", basicSalary=" + basicSalary +
                ", beforeSalary=" + beforeSalary +
                ", afterSalary=" + afterSalary +
                ", mealSalary=" + mealSalary +
                ", incomTax=" + incomTax +
                ", healthTax=" + healthTax +
                ", nationalTax=" + nationalTax +
                ", paymentDate=" + paymentDate +
                ", paymentsYn='" + paymentsYn + '\'' +
                ", tax=" + tax +
                ", bonus=" + bonus +
                ", member=" + member +
                '}';
    }
}
