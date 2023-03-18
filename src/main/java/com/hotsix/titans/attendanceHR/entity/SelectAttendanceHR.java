package com.hotsix.titans.attendanceHR.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_ATTENDANCE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SelectAttendanceHR {

    @Id
    @Column(name = "COMMUTE_CODE")
    private String commuteCode;

    @Column(name = "COMMUTE_DATE")
    private LocalDateTime commuteDate;

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

//    @Column(name = "MEMBER_CODE")
//    private String memberCode;

    @OneToMany
    @JoinColumn(name = "COMMUTE_NO")
    private List<AttendanceHrReason> attendanceHrReasonList;

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE", insertable = false, updatable = false)
    private MemberAttendance memberAttendance;



    @Override
    public String toString() {
        return "AttendanceHR{" +
                "commuteCode='" + commuteCode + '\'' +
                ", commuteDate=" + commuteDate +
                ", commuteStartTime=" + commuteStartTime +
                ", commuteScountTime=" + commuteScountTime +
                ", commuteFinishTime=" + commuteFinishTime +
                ", commuteFcountTime=" + commuteFcountTime +
                ", commuteTotalTime=" + commuteTotalTime +
                ", commuteStatus='" + commuteStatus + '\'' +

                '}';
    }
}
