package com.hotsix.titans.attendanceHR.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AttendanceHrReasonDTO {

    private String	reasonCode;
    private String	commuteNo;
    private String	reasonCategory;
    private String	reasonTitle;
    private String	reasonDetail;
    private String	reasonFname;
    private String	reasonCname;
    private String	reasonFaddress;
    private String	reasonFtype;
    private Date    reasonFcreate;
    private String	reasonStatus;
    private String	reasonDyn;
    private AttendanceHrDTO attendanceHr;


}
