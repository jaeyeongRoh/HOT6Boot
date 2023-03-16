package com.hotsix.titans.electronicApproval.entity;


import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@DiscriminatorValue("휴가신청")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_LEAVE")
@DynamicInsert
public class EALeave extends EADocument {


    @Column(name = "LEAVE_START_DATE")
    private LocalDate leaveStartDate;

    @Column(name = "LEAVE_END_DATE")
    private LocalDate leaveEndDate;

    @Column(name = "LEAVE_CATEGORY_CODE")
    private String leaveCategoryCode;

    @ManyToOne
    @JoinColumn(name = "LEAVE_CATEGORY_CODE", insertable = false, updatable = false)
    private LeaveCategory leaveCategory;
}
