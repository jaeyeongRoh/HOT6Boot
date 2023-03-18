package com.hotsix.titans.attendanceHR.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_ATTENDANCE_REASON")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@DynamicInsert
public class AttendanceHrReason {

    @Id
    @Column(name = "REASON_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ATTENDANCE_REASON_CODE")
    @GenericGenerator(name = "SEQ_ATTENDANCE_REASON_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "AHR")
            })
    private String	reasonCode;

    @Column(name = "COMMUTE_NO")
    private String	commuteCode;

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
