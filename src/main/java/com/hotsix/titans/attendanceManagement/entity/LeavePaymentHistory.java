package com.hotsix.titans.attendanceManagement.entity;

import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryDTO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
