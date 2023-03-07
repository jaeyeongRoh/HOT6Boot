package com.hotsix.titans.salary.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import com.hotsix.titans.salary.entity.Salary;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
//@SequenceGenerator(
//    name = "SALARY_SEQ_GENERATOR",
//    sequenceName = "SEQ_SALARY",
//    initialValue = 1,
//    allocationSize = 50
//)
@Table(name = "TBL_BONUS_SALARY")
public class Bonus {

    @Id
    @Column(name = "BONUS_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BONUS_CODE")
    @GenericGenerator(name = "SEQ_BONUS_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "BS")
            })
    private String bonusCode;

    @Column(name = "BONUS_SALARY_TYPE")         // 상여 구분
    private String bonusType;

    @Column(name = "BONUS_SALARY")              // 상여 금액
    private Long bonusSalary;

    @Column(name = "BONUS_PAYMENTS_DATE")       // 지급일
    private Date bonusPaymentsDate;

}

