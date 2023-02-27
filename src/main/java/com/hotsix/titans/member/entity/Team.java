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


    @JoinColumn(name = "AUTHORITY_NAME")
    @ManyToOne
    private Authority authority;

    public Team() {
    }

    public Team(int teamCode, String teamName, Authority authority) {
        this.teamCode = teamCode;
        this.teamName = teamName;
        this.authority = authority;
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


    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }


    @Override
    public String toString() {
        return "Team{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", authority=" + authority +
                '}';
    }
}

