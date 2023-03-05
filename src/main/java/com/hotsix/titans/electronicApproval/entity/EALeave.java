package com.hotsix.titans.electronicApproval.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "TBL_EA_LEAVE")
public class EALeave extends EADocument {

    @Column(name = "LEAVE_START_DATE")
    private Date leaveStartDate;

    @Column(name = "LEAVE_END_DATE")
    private Date leadvEndDate;
}
