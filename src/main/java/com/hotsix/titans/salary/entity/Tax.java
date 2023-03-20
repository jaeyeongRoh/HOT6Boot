package com.hotsix.titans.salary.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DynamicInsert
@Table(name = "TBL_TAX")
public class Tax {

    @Id
    @Column(name = "TAX_CODE")
    private int taxCode;

    @Column(name = "INCOM_TAX_RATE")
    private Double incomTaxRate = 0.066;

    @Column(name = "HEALTH_TAX_RATE")
    private Double healthTaxRate = 0.0306;

    @Column(name = "NATIONAL_TAX_RATE")
    private Double nationalTaxRate = 0.081;


}
