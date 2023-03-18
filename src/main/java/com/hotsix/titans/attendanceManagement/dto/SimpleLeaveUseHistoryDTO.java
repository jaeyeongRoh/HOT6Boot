package com.hotsix.titans.attendanceManagement.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SimpleLeaveUseHistoryDTO {

    private String leaveUseHistoryCode; // 휴가사용내역번호
    private String leavePaymentHistoryCode; // 휴가발생내역번호
    private Date startDate; // 시작일
    private int generationCount;    // 사용갯수
}
