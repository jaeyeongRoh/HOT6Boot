package com.hotsix.titans.attendanceManagement.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LeavePaymentHistoryDTO {

    private String leavePaymentHistorycode; // 휴가발생내역번호

    private String memberCode;              // 사원번호

    private LeaveCategoryDTO leaveCategoryCode;       // 휴가구분번호

    private Date leavePaymentDate;          // 발생날짜

    private int leavePaymentCount;          // 발생갯수

    private int leaveLeftoverCount;         // 잔여갯수

    private String leavePaymentProcess;     // 처리자

    private String leavePaymentMemo;        // 메모

    private char LeavePaymentCancellYn;     // 취소여부
}