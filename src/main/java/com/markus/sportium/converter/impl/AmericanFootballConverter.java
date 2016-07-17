package com.markus.sportium.converter.impl;

import com.markus.sportium.beans.Sport;
import com.markus.sportium.converter.ISportConverter;
import com.markus.sportium.beans.AmericanFootball;
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
            americanFootball = new AmericanFootball();
            americanFootball.setTeamAName(m.group(1));
            americanFootball.setTeamAScore(m.group(3));
            americanFootball.setTeamBName(m.group(7));
            americanFootball.setTeamBScore(m.group(5));
            americanFootball.setCurrentPeriod(m.group(8) + m.group(9));
        }
        return americanFootball;
    }

    @Override
    protected Pattern getPattern() {
        String quarterNumber = "(\\d+)";
        String quarterString = "([Quarter].*)";
        String pattern = teamName + whiteSpace + intScore + stringTraco + intScore + whiteSpace + teamName + quarterNumber + quarterString;
        return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }
}
