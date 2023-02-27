package com.hotsix.titans.salary.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaxDTO {

    private String taxCode;
    private Double incomTaxRate;
    private Double healthTaxRate;
    private Double NationalTaxRate;
}
