package com.hotsix.titans.electronicApproval.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EaCertDTO extends EaDocumentDTO {

    private String certCategory;
    private Integer certRequireCount;
}
