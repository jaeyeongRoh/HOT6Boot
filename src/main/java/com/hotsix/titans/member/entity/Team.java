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

    @OneToMany
    @JoinColumn(name = "TEAM_CODE")
    private List<MemberRole> memberRole;


    public Team() {
    }

    public Team(int teamCode, String teamName, List<MemberRole> memberRole) {
        this.teamCode = teamCode;
        this.teamName = teamName;
        this.memberRole = memberRole;
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

    public List<MemberRole> getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(List<MemberRole> memberRole) {
        this.memberRole = memberRole;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", memberRole=" + memberRole +
                '}';
    }
}

