package com.hotsix.titans.attendanceHR.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SelectAttendanceDTO {

    private String memberName;
    private int teamCode;
    private Date startDate;
    private Date startDate2;
    private String commuteCode;
    private String commuteStatus;


}
