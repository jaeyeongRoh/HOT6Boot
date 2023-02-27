package com.hotsix.titans.member.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_AUTHORITY")
public class Authority {

    @Id
    @Column(name = "AUTHORITY_NAME")
    private String authorityName;

    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

    @OneToMany(mappedBy = "authority")
    private List<Team> teamList;

    public Authority() {
    }

    public Authority(String authorityName, int authorityCode, List<Team> teamList) {
        this.authorityName = authorityName;
        this.authorityCode = authorityCode;
        this.teamList = teamList;
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

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityName='" + authorityName + '\'' +
                ", authorityCode=" + authorityCode +
                ", teamList=" + teamList +
                '}';
    }
}
