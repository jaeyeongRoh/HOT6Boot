package com.hotsix.titans.attendanceManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_LEAVE_PAYMENT_HISTORY")
public class LeaveHistoryAndMember {

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

    @OneToMany
    @JoinColumn(name = "LEAVE_PAYMENT_HISTORY_CODE")
    private List<LeaveUseHistory> leaveUseHistoryList;
}
