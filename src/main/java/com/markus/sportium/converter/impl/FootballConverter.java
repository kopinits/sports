package com.markus.sportium.converter.impl;

import com.markus.sportium.beans.Football;
import com.markus.sportium.beans.Sport;
import com.markus.sportium.converter.ISportConverter;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FootballConverter extends AbstractSportConverter implements ISportConverter {
    @Override
    public Sport convertInputToSport() {
        Football football = null;
        Matcher m = getPattern().matcher(getInputToProcess());
        if (m.find()) {
            football = new Football();
            football.setTeamAName(m.group(1).trim());
            football.setTeamAScore(m.group(3).trim());
            football.setTeamBName(m.group(7).trim());
            football.setTeamBScore(m.group(5).trim());
        }
        return football;
    }

    @Override
    protected Pattern getPattern() {
        String teamAName = "(.*)";
        String pattern = teamAName + whiteSpace + intScore + stringTraco + intScore + whiteSpace + teamAName;
        return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }
}
