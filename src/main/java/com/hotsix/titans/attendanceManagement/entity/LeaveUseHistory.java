package com.hotsix.titans.attendanceManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_LEAVE_USE_HISTORY")
public class LeaveUseHistory {

    @Id
    @Column(name = "LEAVE_USE_HISTORY_CODE")
    private String leaveUseHistoryCode;
    @Column(name = "LEAVE_PAYMENT_HISTORY_CODE")
    private String leavePaymentHistoryCode;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "GENERATION_COUNT")
    private int generationCount;
    @Column(name = "LEAVE_USE_PROCESS")
    private String leaveUseProcess;
    @Column(name = "LEAVE_USE_MEMO")
    private String leaveUseMemo;
    @Column(name = "LEAVE_USE_CANCELL_YN")
    private char leaveUseCancellYn;

    @Override
    public String toString() {
        return "LeaveUseHistory{" +
                "leaveUseHistoryCode='" + leaveUseHistoryCode + '\'' +
                ", leavePaymentHistoryCode='" + leavePaymentHistoryCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", generationCount=" + generationCount +
                ", leaveUseProcess='" + leaveUseProcess + '\'' +
                ", leaveUseMemo='" + leaveUseMemo + '\'' +
                ", leaveUseCancellYn=" + leaveUseCancellYn +
                '}';
    }
}
