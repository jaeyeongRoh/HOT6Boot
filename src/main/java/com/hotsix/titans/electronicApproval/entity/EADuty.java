package com.hotsix.titans.electronicApproval.entity;

import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("duty")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_DUTY")
public class EADuty extends EADocument {

    @Column(name = "DUTY_START_DATE")
    private LocalDate dutyStartDate;

    @Column(name = "DUTY_END_DATE")
    private LocalDate dutyEndDate;

}
