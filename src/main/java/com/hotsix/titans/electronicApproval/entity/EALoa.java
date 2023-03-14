package com.hotsix.titans.electronicApproval.entity;

import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_EA_LOA")
@DiscriminatorValue("loa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EALoa extends EADocument {

    @Column(name = "LOA_DATE")
    private Date loaDate;

    @ManyToOne
    @JoinColumn(name = "LEAVE_CATEGORY_CODE")
    private LeaveCategory leaveCategory;

}
