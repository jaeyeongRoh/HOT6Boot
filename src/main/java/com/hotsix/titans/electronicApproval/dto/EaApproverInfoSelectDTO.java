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
public class EaApproverInfoSelectDTO {

    private String eaCode;

}
