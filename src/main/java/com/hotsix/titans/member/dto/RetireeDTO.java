package com.hotsix.titans.member.dto;

import com.hotsix.titans.member.entity.Rank;
import com.hotsix.titans.member.entity.Team;
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

    private Team team;
    private Rank rank;
}
