package com.hotsix.titans.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RetireeHistoryDTO {

    private String retireeCode;
    private String memberCode;

    private RetireeDTO retiree;

}
