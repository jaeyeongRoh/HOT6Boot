package com.hotsix.titans.attendanceManagement.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeaveHistoryAndMemberDTO {

    private String leavePaymentHistoryCode; // 휴가발생내역번호
    private String leaveCategoryCode;       // 휴가구분번호
    private String memberCode;
    private String leavePaymentDate;          // 발생날짜
    private int leavePaymentCount;          // 발생갯수
    private int leaveLeftoverCount;         // 잔여갯수
    private String leavePaymentProcess;     // 처리자
    private String leavePaymentMemo;        // 메모
    private char LeavePaymentCancellYn;     // 취소여부
    private List<LeaveUseHistoryDTO> leaveUseHistoryList;

    @Override
    public String toString() {
        return "LeaveHistoryAndMemberDTO{" +
                "leavePaymentHistoryCode='" + leavePaymentHistoryCode + '\'' +
                ", leaveCategoryCode='" + leaveCategoryCode + '\'' +
                ", memberCode='" + memberCode + '\'' +
                ", leavePaymentDate='" + leavePaymentDate + '\'' +
                ", leavePaymentCount=" + leavePaymentCount +
                ", leaveLeftoverCount=" + leaveLeftoverCount +
                ", leavePaymentProcess='" + leavePaymentProcess + '\'' +
                ", leavePaymentMemo='" + leavePaymentMemo + '\'' +
                ", LeavePaymentCancellYn=" + LeavePaymentCancellYn +
                '}';
    }
}
