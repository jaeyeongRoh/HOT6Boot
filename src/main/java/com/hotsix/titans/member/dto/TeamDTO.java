package com.hotsix.titans.member.dto;

import java.util.List;

public class TeamDTO {

    private int teamCode;
    private String teamName;

    public TeamDTO() {
    }

    public TeamDTO(int teamCode, String teamName) {
        this.teamCode = teamCode;
        this.teamName = teamName;
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

    @Override
    public String toString() {
        return "TeamDTO{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
