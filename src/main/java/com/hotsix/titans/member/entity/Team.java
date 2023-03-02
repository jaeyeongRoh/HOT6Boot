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
    private List<TeamRole> teamRole;


    public Team() {
    }

    public Team(int teamCode, String teamName, List<TeamRole> teamRole) {
        this.teamCode = teamCode;
        this.teamName = teamName;
        this.teamRole = teamRole;
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

    public List<TeamRole> getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(List<TeamRole> teamRole) {
        this.teamRole = teamRole;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", memberRole=" + teamRole +
                '}';
    }

}

