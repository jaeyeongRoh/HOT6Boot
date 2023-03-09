package com.hotsix.titans.electronicApproval.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EACertDTO extends EADocumentDTO{

    private String certCategory;

    private Integer certRequireCount;
}
