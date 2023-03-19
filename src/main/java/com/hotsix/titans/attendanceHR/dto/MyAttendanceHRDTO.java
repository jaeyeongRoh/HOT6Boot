package com.hotsix.titans.attendanceHR.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyAttendanceHRDTO {

    private String commuteCode;
    private String memberCode;
    private Date commuteDate;
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
