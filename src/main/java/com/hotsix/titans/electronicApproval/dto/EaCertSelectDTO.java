package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.electronicApproval.entity.EaCertCategory;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EaCertSelectDTO extends EaDocumentDTO{

    private EaCertCategory eaCertCategory;
    private Integer certRequireCount;

}
