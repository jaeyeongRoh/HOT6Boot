package com.hotsix.titans.salary.dto;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.salary.entity.Salary;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDTO {

    private String salaryCode;
    private Date paymentDate;
    private String paymentsYn;
    private Long basicSalary;
    private Long beforeSalary;
    private Long afterSalary;
    private Long mealSalary;
    private Long incomTax;
    private Long healthTax;
    private Long nationalTax;
    private BonusDTO bonus;
    private TaxDTO tax;
    private MemberDTO member;

}
