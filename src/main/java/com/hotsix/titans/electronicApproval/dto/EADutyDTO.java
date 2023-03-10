package com.hotsix.titans.electronicApproval.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EADutyDTO extends EADocumentDTO {

    private String dutyCategory;
    private LocalDate dutyStartDate;
    private LocalDate dutyEndDate;

}
