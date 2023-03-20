package com.hotsix.titans.salary.dto;

import com.hotsix.titans.member.entity.Member;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BonusDTO {

    private String bonusCode;
    private String bonusType;
    private Long bonusSalary;
    private Date bonusPaymentsDate;
    private String salaryCode;

    @Override
    public String toString() {
        return "BonusDTO{" +
                "bonusCode='" + bonusCode + '\'' +
                ", bonusType='" + bonusType + '\'' +
                ", bonusSalary=" + bonusSalary +
                ", bonusPaymentsDate=" + bonusPaymentsDate +
                '}';
    }
}
