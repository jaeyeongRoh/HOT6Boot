package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.electronicApproval.entity.EaStatusCategory;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.entity.Member;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EaCertDocumentDTO {


    private String eaCode;
    private String memberCode;
    private MemberDTO member;
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
