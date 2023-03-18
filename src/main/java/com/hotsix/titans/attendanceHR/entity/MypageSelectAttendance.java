package com.hotsix.titans.attendanceHR.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_ATTENDANCE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MypageSelectAttendance {

    @Id
    @Column(name="COMMUTE_CODE")
    private String commuteCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "COMMUTE_DATE")
    private Date commuteDate;

    @Column(name = "COMMUTE_STATUS")
    private String commuteStatus;

}
