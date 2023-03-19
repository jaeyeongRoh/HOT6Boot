package com.hotsix.titans.electronicApproval.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EaApproverDTO {
    private String eaCode;
    private String approverType;
    private String memberCode;
    private String eaComment;
}
