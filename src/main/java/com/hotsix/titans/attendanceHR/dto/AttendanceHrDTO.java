package com.hotsix.titans.attendanceHR.dto;

import com.hotsix.titans.member.dto.MemberDTO;
import lombok.*;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
public class AttendanceHrDTO {

    private String commuteCode;
    private String memberCode;
    private Date commuteDate;
    private Date commuteStartTime;
    private Date commuteScountTime;
    private Date commuteFinishTime;
    private Date commuteFcountTime;
    private int  commuteTotalTime;
    private String commuteStatus;
    private MemberDTO member;
    private String teamName;
    private String rankName;
    private String memberName;



    private List<AttendanceHrReasonDTO> attendanceHrReasonList;


    public String getMemberName() {
        return member.getMemberName();
    }
    public String getTeamName() {
        return member.getTeamName();
    }

    public String getRankName() {
        return member.getRankName();
    }

    @Override
    public String toString() {
        return "AttendanceHrDTO{" +
                "commuteCode='" + commuteCode + '\'' +
                ", memberCode='" + memberCode + '\'' +
                ", commuteDate=" + commuteDate +
                ", commuteStartTime=" + commuteStartTime +
                ", commuteScountTime=" + commuteScountTime +
                ", commuteFinishTime=" + commuteFinishTime +
                ", commuteFcountTime=" + commuteFcountTime +
                ", commuteTotalTime=" + commuteTotalTime +
                ", commuteStatus='" + commuteStatus + '\'' +
                ", attendanceHrReasonList=" + attendanceHrReasonList +
                '}';
    }
}
