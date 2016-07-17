package com.markus.sportium.beans;

public class Tenis extends Sport {
    private Integer teamAGames;
    private Integer teamBGames;
    private Integer teamASetScore;
    private Integer teamBSetScore;
    private Boolean isServing;

    public Boolean getIsServing() {
        return isServing;
    }

    public void setIsServing(boolean isServing) {
        this.isServing = isServing;
    }

    public Integer getTeamAGames() {
        return teamAGames;
    }

    public void setTeamAGames(Integer teamAGames) {
        this.teamAGames = teamAGames;
    }

    public Integer getTeamBGames() {
        return teamBGames;
    }

    public void setTeamBGames(Integer teamBGames) {
        this.teamBGames = teamBGames;
    }

    public Integer getTeamASetScore() {
        return teamASetScore;
    }

    public void setTeamASetScore(Integer teamASetScore) {
        this.teamASetScore = teamASetScore;
    }

    public Integer getTeamBSetScore() {
        return teamBSetScore;
    }

    public void setTeamBSetScore(Integer teamBSetScore) {
        this.teamBSetScore = teamBSetScore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Tenis: ");
        sb.append(super.toString());
        sb.append(", teamAGames='").append(getTeamAGames()).append('\'');
        sb.append(", teamBGames='").append(getTeamBGames()).append('\'');
        sb.append(", teamBServing='").append(getIsServing().booleanValue()).append('\'');
        sb.append(", scoreboard: { elements: [ { title: 'Sets', teamAScore:'");
        sb.append(getTeamASetScore()).append('\'');
        sb.append(", teamBScore='").append(getTeamBSetScore()).append('\'');
        sb.append("} ] } }");
        return sb.toString();
    }
}
