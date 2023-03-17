package com.hotsix.titans.attendanceManagement.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LeavePaymentHistoryAndUseHistoryDTO {

    private String leavePaymentHistoryCode;
    private String leavePaymentDate;
    private int leavePaymentCount;
    private int leaveLeftoverCount;
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
