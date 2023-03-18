package com.hotsix.titans.attendanceManagement.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LeavePaymentHistoryAndUseHistoryDTO {

    private String leavePaymentHistoryCode;     // 휴가발생내역번호
    private String leavePaymentDate;            // 발생날짜
    private int leavePaymentCount;              // 발생갯수
    private int leaveLeftoverCount;             // 잔여갯수
    private List<SimpleLeaveUseHistoryDTO> leaveUseHistoryList;

    @Override
    public String toString() {
        return "LeavePaymentHistoryAndUseHistoryDTO{" +
                "leavePaymentHistoryCode='" + leavePaymentHistoryCode + '\'' +
                ", leavePaymentDate='" + leavePaymentDate + '\'' +
                ", leavePaymentCount=" + leavePaymentCount +
                ", leaveLeftoverCount=" + leaveLeftoverCount +
                '}';
    }
}
