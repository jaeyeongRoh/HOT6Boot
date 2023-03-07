package com.hotsix.titans.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RankDTO {

    private int rankCode;
    private String rankName;
    private int hourlyMoney;

}
