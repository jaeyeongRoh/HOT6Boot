package com.hotsix.titans.attendanceHR.dto;

import com.hotsix.titans.member.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString  주석 아래 정리
public class SelectAttendanceHrDTO {

    private String commuteCode;
    private String memberCode;
    private LocalDateTime commuteDate;
    private Timestamp commuteStartTime;
    private Timestamp commuteScountTime;
    private Timestamp commuteFinishTime;
    private Timestamp commuteFcountTime;
    private int  commuteTotalTime;
    private String commuteStatus;

    private MemberDTO member;


    private List<AttendanceHrReasonDTO> attendanceHrReasonList;




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






//    private String teamName;
//    private String rankName;
//    private String memberName;


//    public String getMemberName() {
//        return member.getMemberName();
//    }
//    public String getTeamName() {
//        return member.getTeamName();
//    }
//    public String getRankName() {
//        return member.getRankName();
//    }