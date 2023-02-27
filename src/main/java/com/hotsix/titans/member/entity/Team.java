package com.hotsix.titans.member.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_TEAM")
public class Team {

    @Id
    @Column(name = "TEAM_CODE")
    private int teamCode;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "REF_TEAM_CODE")
    private int refTeamCode;

    @JoinColumn(name = "AUTHORITY_NAME")
    @ManyToOne
    private Authority authority;

    @OneToMany(mappedBy = "team")
    private List<Member> memberList;


    public Team() {
    }

    public Team(int teamCode, String teamName, int refTeamCode, Authority authority, List<Member> memberList) {
        this.teamCode = teamCode;
        this.teamName = teamName;
        this.refTeamCode = refTeamCode;
        this.authority = authority;
        this.memberList = memberList;
    }

    public int getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(int teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRefTeamCode() {
        return refTeamCode;
    }

    public void setRefTeamCode(int refTeamCode) {
        this.refTeamCode = refTeamCode;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", refTeamCode=" + refTeamCode +
                ", authority=" + authority +
                ", memberList=" + memberList +
                '}';
    }
}

