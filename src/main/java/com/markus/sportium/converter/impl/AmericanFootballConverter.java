package com.markus.sportium.converter.impl;

import com.markus.sportium.beans.AmericanFootball;
import com.markus.sportium.beans.Sport;
import com.markus.sportium.converter.ISportConverter;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AmericanFootballConverter extends AbstractSportConverter implements ISportConverter {
    @Override
    public Sport convertInputToSport() {
        AmericanFootball americanFootball = null;
        Matcher m = verifyConverterType(getInputToProcess());
        if (m.find()) {
            if (m.group(11) != null) {
                if (m.group(11).equals("Quarter")) {
                    americanFootball = new AmericanFootball();
                    americanFootball.setTeamAName(m.group(1).trim());
                    americanFootball.setTeamAScore(m.group(3).trim());
                    americanFootball.setTeamBName(m.group(7).trim());
                    americanFootball.setTeamBScore(m.group(5).trim());
                    americanFootball.setCurrentPeriod(m.group(8).trim() + m.group(9).trim() + " " + m.group(11).trim());
                }
            }
        }
        return americanFootball;
    }

    @Override
    protected Pattern getPattern() {
        String quarterNumber = "(\\d+)";
        String quarterPosition = "(st|nd|rd|th)";
        String quarterString = "(.*)";
        String teamAName = "(.*)";
        String pattern = teamAName + whiteSpace + intScore + stringTraco + intScore + whiteSpace + teamAName + quarterNumber + quarterPosition + whiteSpace + quarterString;
        return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }
}
