package com.hotsix.titans.salary.dto;

import com.hotsix.titans.member.entity.Member;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDTO {

    private String salaryCode;
    private String memberCode;
    private String taxCode;
    private String bonusCode;
    private Date paymentDate;
    private String paymentsYn;
    private Long basicSalary;
    private Long beforeSalary;
    private Long afterSalary;
    private Long mealSalary;
    private Long incomTax;
    private Long healthTax;
    private Long nationalTax;

}
