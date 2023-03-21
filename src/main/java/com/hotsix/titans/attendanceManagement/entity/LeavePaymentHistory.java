package com.hotsix.titans.attendanceManagement.entity;

import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryDTO;
import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TBL_LEAVE_PAYMENT_HISTORY")
public class LeavePaymentHistory {

    @Id
    @Column(name = "LEAVE_PAYMENT_HISTORY_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LEAVE_PAYMENT_CODE")
    @GenericGenerator(name = "SEQ_LEAVE_PAYMENT_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "LP")
            })
    private String leavePaymentHistoryCode; // 휴가발생내역번호

    @Column(name = "MEMBER_CODE")
    private String memberCode;              // 사원번호

    @Column(name = "LEAVE_CATEGORY_CODE")
    private String leaveCategoryCode;       // 휴가구분번호

    @Column(name = "LEAVE_PAYMENT_DATE")
    private String leavePaymentDate;          // 발생날짜

    @Column(name = "LEAVE_PAYMENT_COUNT")
    private int leavePaymentCount;          // 발생갯수

    @Column(name = "LEAVE_LEFTOVER_COUNT")
    private int leaveLeftoverCount;         // 잔여갯수

    @Column(name = "LEAVE_PAYMENT_PROCESS")
    private String leavePaymentProcess;     // 처리자

    @Column(name = "LEAVE_PAYMENT_MEMO")
    private String leavePaymentMemo;        // 메모

    @Column(name = "LEAVE_PAYMENT_CANCELL_YN")
    private char leavePaymentCancellYn;     // 취소여부
}
