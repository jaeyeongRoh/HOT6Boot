package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_CERT_CATEGORY")
public class EaCertCategory {

    @Id
    @Column(name = "CERT_CATEGORY_CODE")
    private String certCategoryCode;

    @Column(name = "CERT_CATEGORY_NAME")
    private String certCategoryName;

}
