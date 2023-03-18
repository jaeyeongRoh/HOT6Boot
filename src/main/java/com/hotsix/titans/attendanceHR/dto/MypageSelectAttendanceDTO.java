package com.hotsix.titans.attendanceHR.dto;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MypageSelectAttendanceDTO {

    private String commuteCode;
    private String memberCode;
    private Date commuteDate;
    private String commuteStatus;

}
