package com.hotsix.titans.electronicApproval.dto;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EALoaDTO extends EADocumentDTO {


    private Date loaDate;
    private String loaCategory;
}
