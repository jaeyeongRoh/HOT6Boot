package com.hotsix.titans.electronicApproval.dto;


import com.hotsix.titans.electronicApproval.entity.EaMember;
import com.hotsix.titans.electronicApproval.entity.EaStatusCategory;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EaApproverInfoDTO {

    private String eaApproverCode;

    private String eaCode;

    private String memberCode;

    private EaMember eaMember;

    private String eaAuthCode;

    private LocalDate eaApproverDate;

    private String eaStatusCode;

    private EaStatusCategory eaStatusCategory;

}
