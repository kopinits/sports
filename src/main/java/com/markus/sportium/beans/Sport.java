package com.markus.sportium.beans;

public class Sport {

    private String teamAName;
    private String teamBName;
    private String teamAScore;
    private String teamBScore;

    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public String getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(String teamAScore) {
        this.teamAScore = teamAScore;
    }

    public String getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(String teamBScore) {
        this.teamBScore = teamBScore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("teamAName='").append(getTeamAName()).append('\'');
        sb.append(", teamBName='").append(getTeamBName()).append('\'');
        sb.append(", teamAScore='").append(getTeamAScore()).append('\'');
        sb.append(", teamBScore='").append(getTeamBScore()).append('\'');
        return sb.toString();
    }
}
