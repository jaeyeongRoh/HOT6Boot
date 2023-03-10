package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "TBL_EA_SAL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EASalary extends EADocument {

    @Column(name = "SAL_CORRECTION_DATE")
    private Date salCorrectionDate;

}