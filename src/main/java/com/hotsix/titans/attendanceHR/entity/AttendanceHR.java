package com.hotsix.titans.attendanceHR.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class AttendanceHR {

    @Id
    @Column(name = "COMMUTE_CODE")
    private String commuteCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "COMMUTE_DATE")
    private Date commuteDate;

    @Column(name = "COMMUTE_START_TIME")
    private Date commuteStartTime;

    @Column(name = "COMMUTE_S_COUNT_TIME")
    private Date commuteScountTime;

    @Column(name = "COMMUTE_FINISH_TIME")
    private Date commuteFinishTime;

    @Column(name = "COMMUTE_F_COUNT_TIME")
    private Date commuteFcountTime;

    @Column(name = "COMMUTE_TOTAL_TIME")
    private int  commuteTotalTime;

    @Column(name = "COMMUTE_STATUS")
    private String commuteStatus;




}
