package com.hotsix.titans.electronicApproval.dto;


import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EADocumentDTO {


    private String eaCode;
    private String memberDraft;
    private String memberMiddleSigner;
    private String memberFinalSigner;
    private String eaSubject;
    private String eaDetail;
    private String eaCategory;
    private String eaType;
    private Date eaDate;
    private Integer eaDraftStatus;
    private Integer eaMiddleStatus;
    private Integer eaMiddleComment;
    private Integer eaFinalStatus;
    private Integer eaFinalComment;
    private Integer eaDocuStatus;


}
