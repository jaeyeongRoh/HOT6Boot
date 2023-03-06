package com.hotsix.titans.electronicApproval.dto;


import lombok.*;

import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EALeaveDTO extends EADocumentDTO {

    private Date leaveStartDate;
    private Date leadvEndDate;

}