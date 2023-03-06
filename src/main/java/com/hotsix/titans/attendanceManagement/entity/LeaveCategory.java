package com.hotsix.titans.attendanceManagement.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TBL_LEAVE_CATEGORY")
@SequenceGenerator(
        name = "LEAVE_CATEGORY_SEQ_GENERATOR",
        sequenceName = "SEQ_LEAVE_CATEGORY_CODE",
        initialValue = 1, allocationSize = 1
)
public class LeaveCategory {


    @Id
    @Column(name = "LEAVE_CATEGORY_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_category_seq")
    @GenericGenerator(name = "leave_category_seq", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "SEQ_LEAVE_CATEGORY_CODE"),
                    @Parameter(name = "prefix", value = "LC")
            })
    private String leaveCategoryCode;       // 휴가구분번호

    @Column(name = "LEAVE_CATEGORY_NAME")
    private String leaveCategoryName;       // 휴가명

    @Column(name = "LEAVE_CATEGORY_DATE")
    private int leaveCategoryDateCount;     // 일수

    @Column(name = "LEAVE_PAY_STATE")
    private int leavePayState;              // 휴가급여상태
}
