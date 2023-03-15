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
@Table(name = "TBL_EA_STATUS_CATEGORY")
public class EAStatusCategory {

    @Id
    @Column(name = "EA_STATUS_CODE")
    private String eaStatusCode;

    @Column(name = "EA_STATUS_NAME")
    private String eaStatusName;

}
