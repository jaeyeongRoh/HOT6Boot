package com.hotsix.titans.attendanceManagement.entity;

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
    @GeneratedValue(generator = "LEAVE_CATEGORY_SEQ_GENERATOR")
    @GenericGenerator(name = "LEAVE_CATEGORY_SEQ_GENERATOR", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "SEQ_LEAVE_CATEGORY_CODE"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1"),
                    @Parameter(name = "optimizer", value = "pooled-lo"),
                    @Parameter(name = "sequence_prefix", value = "LC")
            })
    @Type(type = "org.hibernate.type.StringType")
    private String leaveCategoryCode;       // 휴가구분번호

    @Column(name = "LEAVE_CATEGORY_NAME")
    private String leaveCategoryName;       // 휴가명

    @Column(name = "LEAVE_CATEGORY_DATE")
    private int leaveCategoryDateCount;     // 일수

    @Column(name = "LEAVE_PAY_STATE")
    private int leavePayState;              // 휴가급여상태
}
