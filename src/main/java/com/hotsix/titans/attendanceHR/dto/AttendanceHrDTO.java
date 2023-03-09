package com.hotsix.titans.attendanceHR.dto;

import lombok.*;

import java.util.Date;


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
    private int  commuteTotalTime;
    private String ommuteStatus;

}
