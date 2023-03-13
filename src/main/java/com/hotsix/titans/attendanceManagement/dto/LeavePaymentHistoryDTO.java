package com.hotsix.titans.attendanceManagement.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LeavePaymentHistoryDTO {

    private String leavePaymentHistoryCode; // 휴가발생내역번호

    private String memberCode;              // 사원번호

    private String leaveCategoryCode;       // 휴가구분번호

    private String leavePaymentDate;          // 발생날짜

    private int leavePaymentCount;          // 발생갯수

    private int leaveLeftoverCount;         // 잔여갯수

    private String leavePaymentProcess;     // 처리자x22

    private String leavePaymentMemo;        // 메모

    private char LeavePaymentCancellYn;     // 취소여부
}