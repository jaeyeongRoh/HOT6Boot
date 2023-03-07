package com.hotsix.titans.member.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RetireeDTO {

    private String retireeCode;

    private Date retireeDate;

    private Long severanceMoney;

    private String severancePaymentsYn;

    private Date paymentsDate;
}
