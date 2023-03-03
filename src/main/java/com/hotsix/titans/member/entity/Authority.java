package com.hotsix.titans.member.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "TBL_AUTHORITY")
public class Authority {

    @Id
    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

    @Column(name = "AUTHORITY_NAME")
    private String authorityName;

}
