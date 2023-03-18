package com.hotsix.titans.attendanceManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_LEAVE_USE_HISTORY")
public class SimpleLeaveUseHistory {

    @Id
    @Column(name = "LEAVE_USE_HISTORY_CODE")
    private String leaveUseHistoryCode;
    @Column(name = "LEAVE_PAYMENT_HISTORY_CODE")
    private String leavePaymentHistoryCode;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "GENERATION_COUNT")
    private int generationCount;

    @Override
    public String toString() {
        return "SimpleLeaveUseHistory{" +
                "leaveUseHistoryCode='" + leaveUseHistoryCode + '\'' +
                ", leavePaymentHistoryCode='" + leavePaymentHistoryCode + '\'' +
                ", startDate=" + startDate +
                ", generationCount=" + generationCount +
                '}';
    }
}
