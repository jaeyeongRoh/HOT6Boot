package com.hotsix.titans.electronicApproval.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_EA_ENTR")
@DiscriminatorValue("퇴직신청")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EAEntire extends EADocument {
    @Column(name = "ENTIRE_DATE")
    private Date entireDate;
}
