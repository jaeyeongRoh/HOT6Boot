package com.hotsix.titans.electronicApproval.dto;

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
    private EAMemberDTO eaMemberDTO;
    private String eaSubject;
    private String eaDetail;
    private LocalDate eaDate;
    private Character isDeleted;
    private String eaStatusCode;
    private EAStatusCategoryDTO eaStatusCategoryDTO;
    private List<EAApproverInfoDTO> eaApproverInfoListDTO;
    private String dtype;
}
