package com.hotsix.titans.member.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_AUTHORITY")
public class Authority {

    @Id
    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

    @Column(name = "AUTHORITY_NAME")
    private String authorityName;

    public Authority() {
    }

    public Authority(String authorityName, int authorityCode) {
        this.authorityName = authorityName;
        this.authorityCode = authorityCode;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }


    @Override
    public String toString() {
        return "Authority{" +
                "authorityName='" + authorityName + '\'' +
                ", authorityCode=" + authorityCode +
                '}';
    }
}
