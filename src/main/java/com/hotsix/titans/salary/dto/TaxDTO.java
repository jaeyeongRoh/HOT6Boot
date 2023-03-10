package com.hotsix.titans.salary.dto;

import com.hotsix.titans.salary.entity.Salary;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
