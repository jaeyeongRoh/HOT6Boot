package com.hotsix.titans.electronicApproval.entity;

import com.hotsix.titans.commons.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_APPROVER_INFO")
@DynamicInsert
public class EAApproverInfo {

    @Id
    @Column(name = "EA_APPROVER_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EA_APPROVER")
    @GenericGenerator(name = "SEQ_EA_APPROVER",
            strategy = "com.hotsix.titans.commons.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EA"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    private String eaApproverCode;

    @Column(name = "EA_CODE")
    private String eaCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "EA_AUTH_CODE")
    private String eaAuthCode;

    @Column(name = "EA_APPROVER_DATE")
    private LocalDate eaApproverDate;

    @Column(name = "EA_STATUS_CODE")
    private String eaStatusCode;


}
