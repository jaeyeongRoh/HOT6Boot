package com.hotsix.titans.electronicApproval.dto;


import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EaLoaDTO extends EaDocumentDTO {

    private Date loaDate;
    private LeaveCategory leaveCategory;
}
