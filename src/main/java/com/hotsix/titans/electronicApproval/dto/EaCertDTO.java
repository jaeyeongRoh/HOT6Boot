package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.electronicApproval.entity.EaCertCategory;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EaCertDTO extends EaDocumentDTO {

    private String certCategoryCode;
    private EaCertCategory eaCertCategory;
    private Integer certRequireCount;
}