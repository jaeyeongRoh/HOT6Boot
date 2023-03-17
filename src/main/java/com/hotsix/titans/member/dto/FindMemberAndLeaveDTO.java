package com.hotsix.titans.member.dto;

import com.hotsix.titans.attendanceManagement.dto.LeavePaymentHistoryAndUseHistoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FindMemberAndLeaveDTO {

    private String memberCode;
    private String memberName;
    private Date joinDate;
    private String teamName;
    private String rankName;
    private List<LeavePaymentHistoryAndUseHistoryDTO> leavePaymentHistoryAndUseHistoryList;

    @Override
    public String toString() {
        return "MemberAndLeaveDTO{" +
                "memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", joinDate=" + joinDate +
                ", teamName='" + teamName + '\'' +
                ", rankName='" + rankName + '\'' +
                '}';
    }
}
