package com.hotsix.titans.member.entity;

import javax.persistence.*;

@Entity
@Table(name = "TBL_RETIREE_HISTORY")
public class RetireeHistory {

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "RETIREE_CODE")
    private Retiree retiree;
}
