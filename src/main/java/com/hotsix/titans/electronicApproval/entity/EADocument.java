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
@Table(name = "TBL_EA")
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

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE")
    private EAMember eaMember;

    @Column(name = "EA_SUBJECT")
    private String eaSubject;

    /* 읽기 전용으로 설정해야 DTO에 mapping이 가능함. */
    @Column(name = "DTYPE", insertable = false, updatable = false)
    private String dtype;

    @Column(name = "EA_DETAIL")
    private String eaDetail;

    @Column(name = "EA_DATE")
    private Date eaDate;

    @Column(name = "EA_DELETE_YN")
    private String isDeleted;


}
