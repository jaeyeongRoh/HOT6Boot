package com.hotsix.titans.attendanceManagement.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LeaveUseHistoryDTO {

    private String leaveUseHistoryCode; // 휴가사용내역번호
    private String leavePaymentHistoryCode; // 휴가발생내역번호
    private Date startDate; // 시작일
    private Date endDate;   // 종료일
    private int generationCount;    // 사용갯수
    private String leaveUseProcess; // 처리자
    private String leaveUseMemo;    // 메모
    private char leaveUseCancellYn; // 취소여부
}
