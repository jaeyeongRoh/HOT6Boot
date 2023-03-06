package com.hotsix.titans.attendanceManagement.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TBL_LEAVE_CATEGORY")
public class LeaveCategoryAndLeavePaymentHistory {

    @Id
    @Column(name = "LEAVE_CATEGORY_CODE")
    private String leaveCategoryCode;       // 휴가구분번호

    @Column(name = "LEAVE_CATEGORY_NAME")
    private String leaveCategoryName;       // 휴가명

    @Column(name = "LEAVE_CATEGORY_DATE")
    private int leaveCategoryDateCount;     // 일수

    @Column(name = "LEAVE_PAY_STATE")
    private int leavePayState;              // 휴가급여상태
}
