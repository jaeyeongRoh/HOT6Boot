package com.hotsix.titans.member.dto;

public class RankDTO {

    private int rankCode;
    private String rankName;
    private int hourlyMoney;

    public RankDTO() {
    }

    public RankDTO(int rankCode, String rankName, int hourlyMoney) {
        this.rankCode = rankCode;
        this.rankName = rankName;
        this.hourlyMoney = hourlyMoney;
    }

    public int getRankCode() {
        return rankCode;
    }

    public void setRankCode(int rankCode) {
        this.rankCode = rankCode;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public int getHourlyMoney() {
        return hourlyMoney;
    }

    public void setHourlyMoney(int hourlyMoney) {
        this.hourlyMoney = hourlyMoney;
    }

    @Override
    public String toString() {
        return "RankDTO{" +
                "rankCode=" + rankCode +
                ", rankName='" + rankName + '\'' +
                ", hourlyMoney=" + hourlyMoney +
                '}';
    }
}
