package com.hotsix.titans.salary.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TBL_TAX")
//@SequenceGenerator(
//    name = "TAX_SEQ_GENERATOR",
//    sequenceName = "SEQ_TAX",
//    initialValue = 1,
//    allocationSize = 50
//)
public class Tax {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAX")
    @Column(name = "TAX_CODE")
    private String taxCode;

    @Column(name = "INCOM_TAX_RATE")
    private Double incomTaxRate;

    @Column(name = "HEALTH_TAX_RATE")
    private Double healthTaxRate;

    @Column(name = "NATIONAL_TAX_RATE")
    private Double nationalTaxRate;


}
