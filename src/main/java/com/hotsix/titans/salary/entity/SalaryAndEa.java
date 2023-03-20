package com.hotsix.titans.salary.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "TBL_SALARY")
public class SalaryAndEa {

    @Id
    @Column(name = "SALARY_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SALARY_CODE")
    @GenericGenerator(name = "SEQ_SALARY_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "SAL")
            })
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BONUS_CODE")
    private Bonus bonus;

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
                ", bonus=" + bonus +
                '}';
    }
}
