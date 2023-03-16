package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.electronicApproval.entity.EAApproverInfo;
import com.hotsix.titans.electronicApproval.entity.EAMember;
import com.hotsix.titans.electronicApproval.entity.EAStatusCategory;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EADocumentDTO {


    private String eaCode;
    private String memberCode;
    private EAMember eaMember;
    private String eaSubject;
    private String eaDetail;
    private LocalDate eaDate;
    private Character isDeleted;
    private String eaStatusCode;
    private EAStatusCategory eaStatusCategory;
    private List<EAApproverInfoDTO> eaApproverInfoList;
    private String dtype;
}
