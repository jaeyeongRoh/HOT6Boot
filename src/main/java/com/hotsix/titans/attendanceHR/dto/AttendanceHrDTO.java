package com.hotsix.titans.attendanceHR.dto;

import com.hotsix.titans.member.dto.MemberDTO;
import lombok.*;

import java.sql.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AttendanceHrDTO {

    private String commuteCode;
    private String memberCode;
    private Date commuteDate;
    private Date commuteStartTime;
    private Date commuteScountTime;
    private Date commuteFinishTime;
    private Date commuteFcountTime;
    private int commuteTotalTime;
    private int commuteTotalMonthTime;
    private String commuteStatus;
    private MemberDTO member;
    private List<AttendanceHrReasonDTO> attendanceHrReasonList;

}
