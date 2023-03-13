package com.hotsix.titans.electronicApproval.entity;


import com.hotsix.titans.commons.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TBL_EA")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EADocument {

    @Id
    @Column(name = "EA_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EA")
    @GenericGenerator(name = "SEQ_EA",
                      strategy = "com.hotsix.titans.commons.StringPrefixedSequenceIdGenerator",
                      parameters = {
                            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EA"),
                            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d")
    })
    private String eaCode;

    @Column(name = "MEMBER_DRAFT")
    private String memberDraft;

    @Column(name = "MEMBER_MIDDLE_SIGNER")
    private String memberMiddleSigner;

    @Column(name = "MEMBER_FINAL_SIGNER")
    private String memberFinalSigner;

    @Column(name = "EA_SUBJECT")
    private String eaSubject;

    /* 읽기 전용으로 설정해야 DTO에 mapping이 가능함. */
    @Column(name = "DTYPE", insertable=false, updatable = false)
    private String dtype;

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
