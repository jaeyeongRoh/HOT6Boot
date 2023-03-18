package com.hotsix.titans.electronicApproval.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@DiscriminatorValue("복직신청")
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_RNSTT")
@DynamicInsert
public class EaRnstt extends EaDocument {

    @Column(name = "RNSTT_DATE")
    private LocalDate rnsttDate;

}
