package com.hotsix.titans.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_RANK")
public class Rank {

    @Id
    @Column(name = "RANK_CODE")
    private int rankCode;

    @Column(name = "RANK_NAME")
    private String rankName;
}
