package com.hotsix.titans.attendanceManagement.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TBL_LEAVE_CATEGORY")
public class LeaveCategory {

    @Id
    @Column(name = "LEAVE_CATEGORY_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LEAVE_CATEGORY_CODE")
    @GenericGenerator(name = "SEQ_LEAVE_CATEGORY_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "LP")
            })
    private String leaveCategoryCode;       // 휴가구분번호

    @Column(name = "LEAVE_CATEGORY_NAME")
    private String leaveCategoryName;       // 휴가명

    @Column(name = "LEAVE_CATEGORY_DATE")
    private int leaveCategoryDateCount;     // 일수

    @Column(name = "LEAVE_PAY_STATE")
    private int leavePayState;              // 휴가급여상태
}
