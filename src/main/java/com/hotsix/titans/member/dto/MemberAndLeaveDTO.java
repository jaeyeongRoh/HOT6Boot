package com.hotsix.titans.member.dto;

import com.hotsix.titans.attendanceManagement.dto.LeavePaymentHistoryAndUseHistoryDTO;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberAndLeaveDTO {

    private String memberCode;
    private String memberName;
    private Date joinDate;
    private String teamName;
    private String rankName;
    private String workingStatus;
    private List<LeavePaymentHistoryAndUseHistoryDTO> leavePaymentHistoryAndUseHistoryList;

    @Override
    public String toString() {
        return "MemberAndLeaveDTO{" +
                "memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", joinDate=" + joinDate +
                ", teamName='" + teamName + '\'' +
                ", rankName='" + rankName + '\'' +
                ", workingStatus='" + workingStatus + '\'' +
                ", leavePaymentHistoryAndUseHistoryList=" + leavePaymentHistoryAndUseHistoryList +
                '}';
    }
}
