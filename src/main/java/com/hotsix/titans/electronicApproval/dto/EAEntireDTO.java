package com.hotsix.titans.electronicApproval.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EAEntireDTO extends EADocumentDTO {

    private Date entireDate;
}
