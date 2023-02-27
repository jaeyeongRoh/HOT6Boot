package com.hotsix.titans.member.entity;

import java.io.Serializable;

public class RetireeHistoryPk implements Serializable {

    private String memberCode;
    private String retireeCode;

    public RetireeHistoryPk() {
    }

    public RetireeHistoryPk(String memberCode, String retireeCode) {
        this.memberCode = memberCode;
        this.retireeCode = retireeCode;
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

    @Override
    public String toString() {
        return "RetireeHistoryPk{" +
                "memberCode='" + memberCode + '\'' +
                ", retireeCode='" + retireeCode + '\'' +
                '}';
    }
}
