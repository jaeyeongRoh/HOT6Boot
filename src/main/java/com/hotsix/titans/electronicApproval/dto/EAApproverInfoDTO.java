package com.hotsix.titans.electronicApproval.dto;


import com.hotsix.titans.electronicApproval.entity.EAStatusCategory;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EAApproverInfoDTO {

    private String eaApproverCode;

    private String eaCode;

    private String memberCode;

    private String eaAuthCode;

    private LocalDate eaApproverDate;

    private String eaStatusCode;

    private EAStatusCategory eaStatusCategory;

}
