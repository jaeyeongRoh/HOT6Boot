package com.hotsix.titans.salary.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BonusDTO {

    private String bonusCode;
    private String bonusType;
    private Long bonusSalary;
    private Date paymentDate;
}
