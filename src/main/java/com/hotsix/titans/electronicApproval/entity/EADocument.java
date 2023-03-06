package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="TBL_EA")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="EA_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EADocument {

    @Id
    @Column(name = "EA_CODE")
    private String eaCode;

    @Column(name = "MEMBER_DRAFT")
    private String memberDraft;

    @Column(name = "MEMBER_MIDDLE_SIGNER")
    private String memberMiddleSigner;

    @Column(name = "MEMBER_FINAL_SIGNER")
    private String memberFinalSigner;

    @Column(name = "EA_SUBJECT")
    private String eaSubject;

    @Column(name = "EA_TYPE")
    private String eaType;

    @Column(name = "EA_DETAIL")
    private String eaDetail;

    @Column(name = "EA_CATEGORY")
    private String eaCategory;

    @Column(name = "EA_DATE")
    private LocalDate eaDate;

    @Column(name = "EA_DRAFT_STATUS")
    private Integer eaDraftStatus;

    @Column(name = "EA_MIDDLE_STATUS")
    private Integer eaMiddleStatus;

    @Column(name = "EA_MIDDLE_COMMENT")
    private String eaMiddleComment;

    @Column(name = "EA_FINAL_STATUS")
    private Integer eaFinalStatus;

    @Column(name = "EA_FINAL_COMMENT")
    private String eaFinalComment;

    @Column(name = "EA_DOCU_STATUS")
    private Integer eaDocuStatus;

    @Column(name = "IS_DELETED")
    private String isDeleted;

}
