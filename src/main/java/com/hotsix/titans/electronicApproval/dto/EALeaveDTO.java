package com.hotsix.titans.electronicApproval.dto;


import lombok.*;


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
}