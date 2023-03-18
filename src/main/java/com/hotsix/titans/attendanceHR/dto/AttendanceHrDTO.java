package com.hotsix.titans.attendanceHR.dto;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString  주석 아래 정리
public class AttendanceHrDTO {

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
