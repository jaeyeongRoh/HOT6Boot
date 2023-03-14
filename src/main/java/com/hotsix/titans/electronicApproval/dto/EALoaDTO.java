package com.hotsix.titans.electronicApproval.dto;


import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EALoaDTO extends EADocumentDTO {

    private Date loaDate;
    private LeaveCategory leaveCategory;
}
