package com.hotsix.titans.electronicApproval.entity;

import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.entity.SalaryAndEa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "TBL_EA_SALARY")
@DiscriminatorValue("급여정정 신청")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
public class EaSalaryList extends EaCertDocument {

    @Column(name = "SAL_CORRECTION_DATE")
    private LocalDate salCorrectionDate;

    @Column(name = "SALARY_CODE")
    private String salaryCode;

    @ManyToOne
    @JoinColumn(name = "SALARY_CODE", insertable = false, updatable = false)
    private SalaryAndEa salary;
}
