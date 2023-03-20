package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "TBL_EA_CERT")
@DiscriminatorValue("증명서 신청")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
public class EaCert extends EaDocument {

    @Column(name = "CERT_CATEGORY_CODE")
    private String certCategoryCode;

    @ManyToOne
    @JoinColumn(name = "CERT_CATEGORY_CODE", insertable = false, updatable = false)
    private EaCertCategory eaCertCategory;

    @Column(name = "CERT_REQUIRE_COUNT")
    private Integer certRequireCount;
}
