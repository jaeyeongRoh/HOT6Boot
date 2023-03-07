package com.hotsix.titans.member.entity;

import javax.persistence.*;

@Entity
@Table(name = "TBL_RETIREE_HISTORY")
@IdClass(RetireeHistoryPk.class)
public class RetireeHistory {

    @Id
    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Id
    @Column(name = "RETIREE_CODE")
    private String retireeCode;

    @ManyToOne
    @JoinColumn(name = "RETIREE_CODE", insertable = false, updatable = false)
    private Retiree retiree;

    public RetireeHistory(String memberCode, String retireeCode) {
        this.memberCode = memberCode;
        this.retireeCode = retireeCode;
    }

    public RetireeHistory(String memberCode, String retireeCode, Retiree retiree) {
        this.memberCode = memberCode;
        this.retireeCode = retireeCode;
        this.retiree = retiree;
    }

    public RetireeHistory() {

    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getRetireeCode() {
        return retireeCode;
    }

    public void setRetireeCode(String retireeCode) {
        this.retireeCode = retireeCode;
    }

    public Retiree getRetiree() {
        return retiree;
    }

    public void setRetiree(Retiree retiree) {
        this.retiree = retiree;
    }

    @Override
    public String toString() {
        return "RetireeHistory{" +
                "memberCode='" + memberCode + '\'' +
                ", retireeCode='" + retireeCode + '\'' +
                ", retiree=" + retiree +
                '}';
    }
}
