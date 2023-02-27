package com.hotsix.titans.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SEVERANCE_PAY")
public class Severance {

    @Id
    @Column(name = "SEVERANCE_CODE")
    private String severanceCode;

    @Column(name = "SEVERANCE_MONEY")
    private String severanceMoney;
}
