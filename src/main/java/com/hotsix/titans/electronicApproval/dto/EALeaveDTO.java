package com.hotsix.titans.electronicApproval.dto;


import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import lombok.*;


import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EALeaveDTO extends EADocumentDTO {
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private String leaveCategoryCode;
    private LeaveCategory leaveCategory;
}