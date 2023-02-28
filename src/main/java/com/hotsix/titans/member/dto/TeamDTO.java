package com.hotsix.titans.member.dto;

public class TeamDTO {

    private int teamCode;
    private String teamName;
    private int authorityCode;

    private AuthorityDTO authority;

    public TeamDTO() {
    }

    public TeamDTO(int teamCode, String teamName, int authorityCode, AuthorityDTO authority) {
        this.teamCode = teamCode;
        this.teamName = teamName;
        this.authorityCode = authorityCode;
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

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public AuthorityDTO getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityDTO authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", authorityCode=" + authorityCode +
                ", authority=" + authority +
                '}';
    }
}
