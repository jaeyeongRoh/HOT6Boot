package com.hotsix.titans.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE", insertable = false, updatable = false)
    private MemberAndRetiree member;


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
