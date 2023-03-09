package com.hotsix.titans.attendanceHR.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_ATTENDANCE_REASON")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AttendanceHrReason {

    @Id
    @Column(name = "REASON_CODE")
    private String	reasonCode;

    @Column(name = "COMMUTE_NO")
    private String	commuteNo;

    @Column(name = "REASON_CATEGORY")
    private String	reasonCategory;

    @Column(name = "REASON_TITLE")
    private String	reasonTitle;

    @Column(name = "REASON_DETAIL")
    private String	reasonDetail;

    @Column(name = "REASON_F_NAME")
    private String	reasonFname;

    @Column(name = "REASON_C_NAME")
    private String	reasonCname;

    @Column(name = "REASON_F_ADDRESS")
    private String	reasonFaddress;

    @Column(name = "REASON_F_TYPE")
    private String	reasonFtype;

    @Column(name = "REASON_F_CREATE")
    private Date reasonFcreate;

    @Column(name = "REASON_STATUS")
    private String	reasonStatus;

    @Column(name = "REASON_D_YN")
    private String	reasonDyn;



}
