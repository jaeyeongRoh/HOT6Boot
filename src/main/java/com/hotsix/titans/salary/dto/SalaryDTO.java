package com.hotsix.titans.salary.dto;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.RankDTO;
import com.hotsix.titans.member.dto.TeamDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.salary.entity.Salary;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
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
    private Long totalTax;
    private int totalTime;
    private String memberCode;
    private String memberName;
    private String teamName;
    private String rankName;
    private TeamDTO team;
    private RankDTO rank;
    private BonusDTO bonus;
    private TaxDTO tax;

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salaryCode='" + salaryCode + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentsYn='" + paymentsYn + '\'' +
                ", basicSalary=" + basicSalary +
                ", beforeSalary=" + beforeSalary +
                ", afterSalary=" + afterSalary +
                ", mealSalary=" + mealSalary +
                ", incomTax=" + incomTax +
                ", healthTax=" + healthTax +
                ", nationalTax=" + nationalTax +
                ", totalTax=" + totalTax +
                ", totalTime=" + totalTime +
                ", memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", team=" + team +
                ", rank=" + rank +
                ", bonus=" + bonus +
                ", tax=" + tax +
                '}';
    }
}
