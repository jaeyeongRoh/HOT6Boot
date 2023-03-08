package com.hotsix.titans.salary.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BonusDTO {

    private String bonusCode;
    private String bonusType;
    private Long bonusSalary;
    private Date bonusPaymentsDate;
}
