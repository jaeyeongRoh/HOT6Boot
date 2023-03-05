package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="TBL_EA")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="DTYPE")
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

    @Column(name = "EA_DETAIL")
    private String eaDetail;

    @Column(name = "EA_CATEGORY")
    private String eaCategory;

    @Column(name = "EA_DATE")
    private Date eaDate;

    @Column(name = "EA_DRAFT_STATUS")
    private Integer eaDraftStatus;

    @Column(name = "EA_MIDDLE_STATUS")
    private Integer eaMiddleStatus;

    @Column(name = "EA_MIDDLE_COMMENT")
    private Integer eaMiddleComment;

    @Column(name = "EA_FINAL_STATUS")
    private Integer eaFinalStatus;

    @Column(name = "EA_FINAL_COMMENT")
    private Integer eaFinalComment;

    @Column(name = "EA_DOCU_STATUS")
    private Integer eaDocuStatus;

    @Override
    public String toString() {
        return "EADocument{" +
                "eaCode='" + eaCode + '\'' +
                ", memberDraft='" + memberDraft + '\'' +
                ", memberMiddleSigner='" + memberMiddleSigner + '\'' +
                ", memberFinalSigner='" + memberFinalSigner + '\'' +
                ", eaSubject='" + eaSubject + '\'' +
                ", eaDetail='" + eaDetail + '\'' +
                ", eaCategory='" + eaCategory + '\'' +
                ", eaDate=" + eaDate +
                ", eaDraftStatus=" + eaDraftStatus +
                ", eaMiddleStatus=" + eaMiddleStatus +
                ", eaMiddleComment=" + eaMiddleComment +
                ", eaFinalStatus=" + eaFinalStatus +
                ", eaFinalComment=" + eaFinalComment +
                ", eaDocuStatus=" + eaDocuStatus +
                '}';
    }
}
