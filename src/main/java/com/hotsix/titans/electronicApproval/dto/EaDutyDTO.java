package com.hotsix.titans.electronicApproval.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EaDutyDTO extends EaDocumentDTO {

    private String dutyCategory;
    private LocalDate dutyStartDate;
    private LocalDate dutyEndDate;

}
