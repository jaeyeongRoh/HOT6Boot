package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.electronicApproval.entity.EaCertCategory;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EaCertListSelectDTO extends EaCertDocumentDTO{

    private EaCertCategory eaCertCategory;
    private Integer certRequireCount;

}
