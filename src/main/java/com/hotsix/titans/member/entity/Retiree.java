package com.hotsix.titans.member.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "TBL_RETIREE")
public class Retiree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RETIREE_CODE")
    @GenericGenerator(name = "SEQ_RETIREE_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER,
                            value = "RC")
    })
    @Column(name = "RETIREE_CODE")
    private String retireeCode;             // 퇴직번호

    @Column(name = "RETIREE_DATE")
    private Date retireeDate;               // 퇴직일

    @Column(name = "SEVERANCE_MONEY")       // 퇴직금  null
    private Long severanceMoney;

    @Column(name = "SEVERANCE_PAYMENTS_YN") // 지급 여부 default N
    private String severancePaymentsYn;

    @Column(name = "PAYMENTS_DATE")         // 지급일
    private Date paymentsDate;



}