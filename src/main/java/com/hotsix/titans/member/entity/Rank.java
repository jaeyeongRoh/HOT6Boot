package com.hotsix.titans.member.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "TBL_RANK")
public class Rank {

    @Id
    @Column(name = "RANK_CODE")
    private int rankCode;

    @Column(name = "RANK_NAME")
    private String rankName;

    @Column(name = "HOURLY_MONEY")
    private Long hourlyMoney;

    private int test;


}
