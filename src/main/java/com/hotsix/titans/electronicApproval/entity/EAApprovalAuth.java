package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_APPROVAL_AUTH")
public class EAApprovalAuth {

    @Id
    @Column(name = "EA_AUTH_CODE")
    private String eaAuthCode;

    @Column(name = "EA_AUTH_NAME")
    private String eaAuthName;

}
