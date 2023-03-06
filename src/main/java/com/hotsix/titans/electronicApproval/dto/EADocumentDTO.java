package com.hotsix.titans.electronicApproval.dto;


import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

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
    private LocalDate eaDate;
    private Integer eaDraftStatus;
    private Integer eaMiddleStatus;
    private String eaMiddleComment;
    private Integer eaFinalStatus;
    private String eaFinalComment;
    private Integer eaDocuStatus;
    private String isDeleted;

}
