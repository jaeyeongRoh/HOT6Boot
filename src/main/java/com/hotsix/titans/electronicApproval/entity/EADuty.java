package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("duty")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_DUTY")
public class EADuty extends EADocument{

    @Column(name = "DUTY_CATEGORY")
    private String dutyCategory;

    @Column(name = "DUTY_DATE_START")
    private LocalDate dutyStartDate;

    @Column(name = "DUTY_DATE_END")
    private LocalDate dutyEndDate;

}
