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
@DiscriminatorValue("rnstt")/*복직신청*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_RNSTT")
@DynamicInsert
public class EARnstt extends EADocument {

    @Column(name = "RNSTT_DATE")
    private LocalDate rnsttDate;

}
