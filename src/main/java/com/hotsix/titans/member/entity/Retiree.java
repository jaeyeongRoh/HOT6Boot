package com.hotsix.titans.member.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "TBL_RETIREE")
//@SequenceGenerator(
//    name = "RETIREE_SEQ_GENERATOR",
//    sequenceName = "SEQ_RETIREE",
//    initialValue = 1,
//    allocationSize = 50)
//)
public class Retiree {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RETIREE")
    @Column(name = "RETIREE_CODE")
    private String retireeCode;             // 퇴직번호

    @Column(name = "RETIREE_DATE")
    private Date retireeDate;               // 퇴직일

    @Column(name = "SEVERANCE_MONEY")
    private Long severanceMoney;

    @Column(name = "SEVERANCE_PAYMENTS_YN")
    private String severancePaymentsYN;

    @Column(name = "PAYMENTS_DATE")
    private Date paymentsDate;


}