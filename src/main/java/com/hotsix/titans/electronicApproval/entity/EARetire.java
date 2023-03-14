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
@Table(name = "TBL_EA_RETIREMENT")
@DiscriminatorValue("retire")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EARetire extends EADocument {
    @Column(name = "RETIRE_DATE")
    private Date entireDate;
}
