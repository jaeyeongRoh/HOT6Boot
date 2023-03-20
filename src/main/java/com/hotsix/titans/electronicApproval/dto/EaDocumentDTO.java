package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.electronicApproval.entity.EaMember;
import com.hotsix.titans.electronicApproval.entity.EaStatusCategory;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EaDocumentDTO {


    private String eaCode;
    private String memberCode;
    private EaMember eaMember;
    private String eaSubject;
    private String eaDetail;
    private LocalDate eaDate;
    private Character isDeleted;
    private String eaStatusCode;
    private EaStatusCategory eaStatusCategory;
    private List<EaApproverInfoDTO> eaApproverInfoList;
    private String dtype;
    private String approverType;
}
