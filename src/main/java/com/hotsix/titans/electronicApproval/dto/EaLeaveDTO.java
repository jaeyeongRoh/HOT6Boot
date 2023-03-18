package com.hotsix.titans.electronicApproval.dto;


import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import lombok.*;


import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EaLeaveDTO extends EaDocumentDTO {
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private String leaveCategoryCode;
    private LeaveCategory leaveCategory;
}