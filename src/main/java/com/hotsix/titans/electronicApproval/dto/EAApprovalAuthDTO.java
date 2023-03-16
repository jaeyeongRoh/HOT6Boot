package com.hotsix.titans.electronicApproval.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EAApprovalAuthDTO {

    private String eaAuthCode;
    private String eaAuthName;

}
