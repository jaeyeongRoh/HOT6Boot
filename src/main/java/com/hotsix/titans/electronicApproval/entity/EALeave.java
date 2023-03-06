package com.hotsix.titans.electronicApproval.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@DiscriminatorValue("휴가신청")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_LEAVE")
public class EALeave extends EADocument {

    @Column(name = "LEAVE_START_DATE")
    private LocalDate leaveStartDate;

    @Column(name = "LEAVE_END_DATE")
    private LocalDate leaveEndDate;
}
