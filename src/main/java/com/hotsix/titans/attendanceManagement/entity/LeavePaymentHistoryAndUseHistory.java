package com.hotsix.titans.attendanceManagement.entity;

import com.hotsix.titans.member.entity.MemberAndLeave;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_LEAVE_PAYMENT_HISTORY")
public class LeavePaymentHistoryAndUseHistory {

    @Id
    @Column(name = "LEAVE_PAYMENT_HISTORY_CODE")
    private String leavePaymentHistoryCode;

    @Column(name = "LEAVE_PAYMENT_DATE")
    private String leavePaymentDate;

    @Column(name = "LEAVE_PAYMENT_COUNT")
    private int leavePaymentCount;

    @Column(name = "LEAVE_LEFTOVER_COUNT")
    private int leaveLeftoverCount;

    @OneToMany
    @JoinColumn(name = "LEAVE_PAYMENT_HISTORY_CODE")
    private List<SimpleLeaveUseHistory> simpleleaveUseHistoryList;

    @Override
    public String toString() {
        return "LeavePaymentHistoryAndUseHistory{" +
                "leavePaymentHistoryCode='" + leavePaymentHistoryCode + '\'' +
                ", leavePaymentDate='" + leavePaymentDate + '\'' +
                ", leavePaymentCount=" + leavePaymentCount +
                ", leaveLeftoverCount=" + leaveLeftoverCount +
                '}';
    }
}
