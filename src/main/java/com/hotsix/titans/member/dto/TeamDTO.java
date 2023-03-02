package com.hotsix.titans.member.dto;

import com.hotsix.titans.member.entity.TeamRole;

import java.util.List;

public class TeamDTO {

    private int teamCode;
    private String teamName;

    private List<TeamRole> teamRole;

    public TeamDTO() {
    }

    public TeamDTO(int teamCode, String teamName, List<TeamRole> teamRole) {
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
        return "TeamDTO{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", teamRole=" + teamRole +
                '}';
    }
}
